package com.example.wph_order_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_order_provider.dao.WphOrderDao;
import com.example.wph_order_provider.dao.WphOrderShopingDao;
import com.example.wph_order_provider.entity.OrderShoping;
import com.example.wph_order_provider.entity.WphOrder;
import com.example.wph_order_provider.entity.WphOrderShoping;
import com.example.wph_order_provider.service.WphOrderService;
import com.example.wph_order_provider.util.DateUtil;
import com.example.wph_order_provider.util.RabbitConfig;
import com.example.wph_order_provider.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (WphOrder)表服务实现类
 *
 * @author makejava
 * @since 2018-12-19 09:15:12
 */
@Service
public class WphOrderServiceImpl implements WphOrderService {

    @Autowired
    private WphOrderDao wphOrderDao;

    @Autowired
    private WphOrderShopingDao wphOrderShopingDao;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisUtil redisUtil;
    Map<String,Object> map=new HashMap<String, Object>();
    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public List<OrderShoping> queryById(Integer orderId) {
        WphOrder wphOrder=wphOrderDao.queryById(orderId);
        List<OrderShoping>list1=new ArrayList();
            OrderShoping orderShoping =new OrderShoping();
            orderShoping.setOrderNo(wphOrder.getOrderNo());
            orderShoping.setOrderadress(wphOrder.getOrderadress());
            orderShoping.setOrderId(wphOrder.getOrderId());
            orderShoping.setUserId(wphOrder.getUserId());
            orderShoping.setOrderMoney(wphOrder.getOrderMoney());
            orderShoping.setOrderPayment(wphOrder.getOrderPayment());
            orderShoping.setOrderpaynumber(wphOrder.getOrderpaynumber());
            orderShoping.setOrderState(wphOrder.getOrderState());
            orderShoping.setOrderTime(wphOrder.getOrderTime());
            orderShoping.setOrderwaybill(wphOrder.getOrderwaybill());
            List<WphOrderShoping> list2=wphOrderShopingDao.queryAll(wphOrder.getOrderId());
            orderShoping.setWphOrderShoping(list2);
            list1.add(orderShoping);

        return list1;
    }

    /**
     * 新增订单
     *
     * @param userid 用户id
     * @param ordershoping 订单商品
     * @param money 总价
     */
    @Override
    public void insert(Integer userid, String ordershoping,Integer money,String orderadress) {
        WphOrder wphOrder=new WphOrder();
        Date date=new Date();
        String no= date.getTime()+""+userid;
        wphOrder.setOrderNo(no);//订单编号生成
        wphOrder.setOrderTime(DateUtil.SchangeD(DateUtil.getNowDate()));
        wphOrder.setOrderState(0);
        wphOrder.setUserId(userid);
        wphOrder.setOrderPayment("未选择");
        wphOrder.setOrderMoney(money);
        wphOrder.setOrderadress(orderadress);
        wphOrderDao.insert(wphOrder);
        Integer orderid=wphOrderDao.selbyno(no);//得到订单id
        wphOrder.setOrderId(orderid);
        List list=JSON.parseArray(ordershoping);
        for (int i=0;i<list.size();i++){
            String shoping=(String) list.get(i);
            List l=JSON.parseArray(shoping);
            String skunumber=(String) l.get(0);
            Integer num=Integer.parseInt((String)l.get(1));
            Integer money1=Integer.parseInt((String)l.get(2));
            wphOrderShopingDao.insert(orderid,skunumber,num,money1);//增加订单商品
        }
        map.put(orderid.toString(),wphOrder);
        redisUtil.hmset("["+userid+"]order",map,18000);
        rabbitTemplate.convertAndSend(RabbitConfig.DLE2_change,RabbitConfig.DLE2_Queue,JSON.toJSONString(wphOrder));
    }

    /**
     * 延时队列监听,二十分钟
     * @param wphOrder 订单中过期信息
     */
    @RabbitListener(queues = RabbitConfig.YS2_Queue)
    public void getb(String wphOrder){
        WphOrder a=JSON.parseObject(wphOrder,WphOrder.class);
        String orderno=a.getOrderNo();
        wphOrderDao.update(orderno,1,"");
        List<WphOrderShoping> li=wphOrderShopingDao.queryAll(a.getUserId());
        rabbitTemplate.convertAndSend(RabbitConfig.KC2_Queue, JSON.toJSONString(li) );
    }


    /**
     * 修改数据
     *
     * @param orderno 订单编号
     * @param orderstate 订单状态
     * @return 实例对象
     */
    @Override
    public String update(String orderno,Integer orderstate,String orderpaynumber) {
        int i=this.wphOrderDao.update(orderno,orderstate,orderpaynumber);
        if(orderstate==1){
            Integer orderid=wphOrderDao.selbyno(orderno);
            List l=wphOrderShopingDao.queryAll(orderid);
            rabbitTemplate.convertAndSend(RabbitConfig.KC2_Queue, l );
        }
        if(i>0){
            return "修改成功";
        }else{
            return "修改失败" ;
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Integer orderid){
        wphOrderShopingDao.deleteById(orderid);
        wphOrderDao.deleteById(orderid);
    }

    @Override
    public List queryAll(Integer userid,Integer pagenum){
        PageHelper.startPage(pagenum,10);
        List<WphOrder>list=wphOrderDao.queryAll(userid);
        List<OrderShoping>list1=new ArrayList();
        for (WphOrder wphOrder:list){
            OrderShoping orderShoping =new OrderShoping();
            orderShoping.setOrderNo(wphOrder.getOrderNo());
            orderShoping.setOrderadress(wphOrder.getOrderadress());
            orderShoping.setOrderId(wphOrder.getOrderId());
            orderShoping.setUserId(wphOrder.getUserId());
            orderShoping.setOrderMoney(wphOrder.getOrderMoney());
            orderShoping.setOrderPayment(wphOrder.getOrderPayment());
            orderShoping.setOrderpaynumber(wphOrder.getOrderpaynumber());
            orderShoping.setOrderState(wphOrder.getOrderState());
            orderShoping.setOrderTime(wphOrder.getOrderTime());
            orderShoping.setOrderwaybill(wphOrder.getOrderwaybill());
            List<WphOrderShoping> list2=wphOrderShopingDao.queryAll(wphOrder.getOrderId());
            orderShoping.setWphOrderShoping(list2);
            list1.add(orderShoping);
        }

        return list1;
    }

    /**
     * 后台查看订单状态
     * @return
     */
    public List<WphOrder> selstate(){
        return wphOrderDao.selstate();
    }


    /**
     * 后台发货
     * @return
     */
    public int updatestate(Integer userid, Integer orderid){
        String orderwaybill="640070137982";
        return wphOrderDao.updatestate(userid,orderwaybill,orderid);
    }

}