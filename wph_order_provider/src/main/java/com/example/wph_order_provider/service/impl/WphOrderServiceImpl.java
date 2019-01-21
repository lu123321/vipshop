package com.example.wph_order_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_order_provider.dao.CommentimgDao;
import com.example.wph_order_provider.dao.WphOrderDao;
import com.example.wph_order_provider.dao.WphOrderShopingDao;
import com.example.wph_order_provider.dao.WphUserCommentDao;
import com.example.wph_order_provider.entity.*;
import com.example.wph_order_provider.service.WphOrderService;
import com.example.wph_order_provider.util.*;
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
    private WphUserCommentDao wphUserCommentDao;

    @Autowired
    private WphOrderShopingDao wphOrderShopingDao;

    @Autowired
    private CommentimgDao commentimgDao;

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
        orderShoping.setS(redisUtil.getExpire("["+wphOrder.getUserId()+"]order"));
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
    public String insert(Integer userid, String ordershoping,double money,String orderadress) {
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
            System.out.println(list.get(i));
            List list1=(List) list.get(i);
            String skunumber=(String) list1.get(0);
            Integer num=(Integer)list1.get(1);
            double money1=Double.parseDouble ((list1.get(2)).toString());
            double price=Double.parseDouble ((list1.get(3)).toString());
            String picture=(String)list1.get(4);
            String skuname=(String)list1.get(5);
            Integer brand=(Integer)list1.get(6);
            wphOrderShopingDao.insert(orderid,skunumber,num,money1,skuname,price,picture,brand);//增加订单商品
        }
        map.put(orderid.toString(),wphOrder);
        redisUtil.hmset("["+userid+"]order",map,60*20);
        rabbitTemplate.convertAndSend(RabbitConfig.DLE2_change,RabbitConfig.DLE2_Queue,JSON.toJSONString(wphOrder));
        return wphOrder.getOrderNo();
    }

    /**
     * 延时队列监听,二十分钟
     * @param wphOrder 订单中过期信息
     */
    @RabbitListener(queues = RabbitConfig.YS2_Queue)
    public void getb(String wphOrder){
        WphOrder a=JSON.parseObject(wphOrder,WphOrder.class);
        String orderno=a.getOrderNo();
        Integer userid=a.getUserId();
        wphOrderDao.update(orderno,1,"");
        List<WphOrderShoping> li=wphOrderShopingDao.queryAll(a.getUserId());
        List<Kc> list=new ArrayList<Kc>();
        for (WphOrderShoping wphOrderShoping : li){
            Kc kc=new Kc();
            kc.setBrand(wphOrderShoping.getOrderbrand());
            kc.setSkunum(wphOrderShoping.getOrderShopingNum());
            kc.setSkunumber(wphOrderShoping.getSkuSerialnumber());
            list.add(kc);
        }
        rabbitTemplate.convertAndSend(RabbitConfig.KC2_Queue, JSON.toJSONString(list));

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
            List<WphOrderShoping> li=wphOrderShopingDao.queryAll(orderid);
            List<Kc> list=new ArrayList<Kc>();
            for (WphOrderShoping wphOrderShoping : li){
                Kc kc=new Kc();
                kc.setBrand(wphOrderShoping.getOrderbrand());
                kc.setSkunum(wphOrderShoping.getOrderShopingNum());
                kc.setSkunumber(wphOrderShoping.getSkuSerialnumber());
                list.add(kc);
            }
            rabbitTemplate.convertAndSend(RabbitConfig.KC2_Queue, JSON.toJSONString(list) );
        }
        if(i>0){
            return "修改成功";
        }else{
            return "修改失败" ;
        }
    }

    @Override
    public int update7(Integer orderid) {
        return wphOrderDao.update7(orderid);
    }

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer orderid){
        int i=wphOrderShopingDao.deleteById(orderid);
        i=wphOrderDao.deleteById(orderid);
        if(i>0){
            return "删除成功";
        }else {
            return "删除失败";
        }

    }

    @Override
    public String queryAll(Integer userid, Integer pagenum,Integer state){
        if (state==0){
            PageHelper.startPage(pagenum,10);
            List<WphOrder>list=wphOrderDao.queryAll(userid);
            PageInfo<WphOrder> pageInfo=new PageInfo<WphOrder>(list);
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

                orderShoping.setS(redisUtil.getExpire("["+userid+"]order"));
                List<WphOrderShoping> list2=wphOrderShopingDao.queryAll(wphOrder.getOrderId());
                orderShoping.setWphOrderShoping(list2);
                list1.add(orderShoping);
            }
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            Paging paging=new Paging();
            return paging.page(total,list1,pagenum,10);
        }else if (state==1){
            PageHelper.startPage(pagenum,10);
            List<WphOrder>list=wphOrderDao.query1(userid);
            PageInfo<WphOrder> pageInfo=new PageInfo<WphOrder>(list);
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

                orderShoping.setS(redisUtil.getExpire("["+userid+"]order"));
                List<WphOrderShoping> list2=wphOrderShopingDao.queryAll(wphOrder.getOrderId());
                orderShoping.setWphOrderShoping(list2);
                list1.add(orderShoping);
            }
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            Paging paging=new Paging();
            return paging.page(total,list1,pagenum,10);
        }else if (state==2){
            PageHelper.startPage(pagenum,10);
            List<WphOrder>list=wphOrderDao.query2(userid);
            PageInfo<WphOrder> pageInfo=new PageInfo<WphOrder>(list);
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

                orderShoping.setS(redisUtil.getExpire("["+userid+"]order"));
                List<WphOrderShoping> list2=wphOrderShopingDao.queryAll(wphOrder.getOrderId());
                orderShoping.setWphOrderShoping(list2);
                list1.add(orderShoping);
            }
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            Paging paging=new Paging();
            return paging.page(total,list1,pagenum,10);
        }else if (state==3){
            PageHelper.startPage(pagenum,10);
            List<WphOrder>list=wphOrderDao.query3(userid);
            PageInfo<WphOrder> pageInfo=new PageInfo<WphOrder>(list);
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

                orderShoping.setS(redisUtil.getExpire("["+userid+"]order"));
                List<WphOrderShoping> list2=wphOrderShopingDao.queryAll(wphOrder.getOrderId());
                orderShoping.setWphOrderShoping(list2);
                list1.add(orderShoping);
            }
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            Paging paging=new Paging();
            return paging.page(total,list1,pagenum,10);
        }else{
            PageHelper.startPage(pagenum,10);
            List<WphOrder>list=wphOrderDao.query4(userid);
            PageInfo<WphOrder> pageInfo=new PageInfo<WphOrder>(list);
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
                orderShoping.setS(redisUtil.getExpire("["+userid+"]order"));
                List<WphOrderShoping> list2=wphOrderShopingDao.queryAll(wphOrder.getOrderId());
                orderShoping.setWphOrderShoping(list2);
                list1.add(orderShoping);
            }
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            Paging paging=new Paging();
            return paging.page(total,list1,pagenum,10);
        }
    }

    @Override
    public List querycountbyorder(Integer userid) {
        List l=new ArrayList();
        l.add(wphOrderDao.queryorder(userid));
        l.add(wphOrderDao.queryorder1(userid));
        l.add(wphOrderDao.queryorder2(userid));
        l.add(wphOrderDao.queryorder3(userid));
        l.add(wphOrderDao.queryorder4(userid));
        return l;
    }

    /**
     * 后台查看订单状态
     * @return
     */
    public String selstate(Integer pagenum){
        PageHelper.startPage(pagenum,10);
        List<WphOrder> list=wphOrderDao.selstate();
        PageInfo<WphOrder> pageInfo=new PageInfo<WphOrder>(list);
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
        Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
        Paging paging=new Paging();

        return paging.page(total,list1,pagenum,10);
    }

    /**
     * 后台查看订单状态
     * @return
     */
    public String seluserstate(Integer userid, Integer pagenum){
        PageHelper.startPage(pagenum,10);
        List<WphOrder> list=wphOrderDao.seluserstate(userid);
        PageInfo<WphOrder> pageInfo=new PageInfo<WphOrder>(list);
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
        Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
        Paging paging=new Paging();

        return paging.page(total,list1,pagenum,10);
    }

    /**
     * 后台发货
     * @return
     */
    public int updatestate(String orderwaybill, Integer orderid){
        return wphOrderDao.updatestate(orderwaybill,orderid);
    }

    /**
     * 后台查看退货
     * @return
     */
    @Override
    public PageInfo hseltuihuo(Integer pagenum) {
        PageHelper.startPage(pagenum,10);
        List<WphOrder>list=wphOrderDao.hseltuihuo();
        PageInfo<WphOrder> pageInfo = new PageInfo<WphOrder>(list);
        return pageInfo;
    }

    /**
     * 前台用户查看自己申请的退货
     * @param userid
     * @return
     */
    @Override
    public String seltuihuo(Integer userid, Integer pagenum,Integer state) {
        if (state==0){
            PageHelper.startPage(pagenum,10);
            List<WphOrder>list=wphOrderDao.seltuihuo(userid);
            PageInfo<WphOrder> pageInfo=new PageInfo<WphOrder>(list);
            List<OrderShoping>list1=new ArrayList();
            for (WphOrder wphOrder:list) {
                OrderShoping orderShoping = new OrderShoping();
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
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            Paging paging=new Paging();
            return paging.page(total,list1,pagenum,10);
        }else if (state==1){
            PageHelper.startPage(pagenum,10);
            List<WphOrder>list=wphOrderDao.seltuihuo1(userid);
            PageInfo<WphOrder> pageInfo=new PageInfo<WphOrder>(list);
            List<OrderShoping>list1=new ArrayList();
            for (WphOrder wphOrder:list) {
                OrderShoping orderShoping = new OrderShoping();
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
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            Paging paging=new Paging();
            return paging.page(total,list1,pagenum,10);
        }else{
            PageHelper.startPage(pagenum,10);
            List<WphOrder>list=wphOrderDao.seltuihuo2(userid);
            PageInfo<WphOrder> pageInfo=new PageInfo<WphOrder>(list);
            List<OrderShoping>list1=new ArrayList();
            for (WphOrder wphOrder:list) {
                OrderShoping orderShoping = new OrderShoping();
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
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            Paging paging=new Paging();
            return paging.page(total,list1,pagenum,10);
        }
    }

    @Override
    public List querycountbytuihuo(Integer userid) {
        List l=new ArrayList();
        l.add(wphOrderDao.querytuohuo(userid));
        l.add(wphOrderDao.querytuohuo1(userid));
        l.add(wphOrderDao.querytuohuo2(userid));
        return l;
    }

    /**
     * 后台允许退货
     * @param orderid
     * @return
     */
    @Override
    public int updatetuihuo(Integer orderid,String paynumber) {
        List<WphOrderShoping> li=wphOrderShopingDao.queryAll(orderid);
        List<Kc> list=new ArrayList<Kc>();
        for (WphOrderShoping wphOrderShoping : li){
            Kc kc=new Kc();
            kc.setBrand(wphOrderShoping.getOrderbrand());
            kc.setSkunum(wphOrderShoping.getOrderShopingNum());
            kc.setSkunumber(wphOrderShoping.getSkuSerialnumber());
            list.add(kc);
        }
        rabbitTemplate.convertAndSend(RabbitConfig.KC2_Queue, JSON.toJSONString(list));
        return wphOrderDao.updatetuihuo(orderid,paynumber);
    }

    @Override
    public int updatetuihuoshibai(Integer state, String shibai, Integer orderid) {
        if (state==50){
            state=3;
        }else {
            state=2;
        }
        return wphOrderDao.updatetuihuoshibai(state, shibai, orderid);
    }

    @Override
    public String queryAllByshoping(Integer pagenum,Integer spuid,Integer state) {
        //查全部
        if(state==0){
            PageHelper.startPage(pagenum,10);
            List<WphUserComment> list = wphUserCommentDao.queryAllByshoping(spuid);
            PageInfo<WphUserComment> pageInfo=new PageInfo<WphUserComment>(list);
            List<WphUserComment> list1 = new ArrayList<WphUserComment>();
            for (WphUserComment w : list){
                Integer commentId = w.getCommentId();
                w.setClist(commentimgDao.queryById(commentId));
                list1.add(w);
            }
            Paging paging=new Paging();
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            return paging.page(total,list1,pagenum,10);
        }else if(state==1){                             //好评
            PageHelper.startPage(pagenum,10);
            List<WphUserComment> list = wphUserCommentDao.queryAllByshoping1(spuid);
            PageInfo<WphUserComment> pageInfo=new PageInfo<WphUserComment>(list);
            List<WphUserComment> list1 = new ArrayList<WphUserComment>();
            for (WphUserComment w : list){
                Integer commentId = w.getCommentId();
                w.setClist(commentimgDao.queryById(commentId));
                list1.add(w);
            }
            Paging paging=new Paging();
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            return paging.page(total,list1,pagenum,10);
        }else if(state==2){                             //中评
            PageHelper.startPage(pagenum,10);
            List<WphUserComment> list = wphUserCommentDao.queryAllByshoping2(spuid);
            PageInfo<WphUserComment> pageInfo=new PageInfo<WphUserComment>(list);
            List<WphUserComment> list1 = new ArrayList<WphUserComment>();
            for (WphUserComment w : list){
                Integer commentId = w.getCommentId();
                w.setClist(commentimgDao.queryById(commentId));
                list1.add(w);
            }
            Paging paging=new Paging();
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            return paging.page(total,list1,pagenum,10);
        }else{                             //差评
            PageHelper.startPage(pagenum,10);
            List<WphUserComment> list = wphUserCommentDao.queryAllByshoping3(spuid);
            PageInfo<WphUserComment> pageInfo=new PageInfo<WphUserComment>(list);
            List<WphUserComment> list1 = new ArrayList<WphUserComment>();
            for (WphUserComment w : list){
                Integer commentId = w.getCommentId();
                w.setClist(commentimgDao.queryById(commentId));
                list1.add(w);
            }
            Paging paging=new Paging();
            Integer total=Integer.parseInt(String.valueOf(pageInfo.getTotal())) ;
            return paging.page(total,list1,pagenum,10);
        }
    }

    @Override
    public List hqueryAllByshoping() {
        return wphUserCommentDao.hqueryAllByshoping();
    }

    @Override
    public Integer updatecomment(String commentHuifu, Integer commentId) {
        return wphUserCommentDao.updatecomment(commentHuifu, commentId);
    }

    @Override
    public String insertcomment(String userid, String spuid, String img, String commentContent, String commentGradle,Integer orderid) {

        List lspuid=JSON.parseArray(spuid);
        List limg=JSON.parseArray(img);
        System.out.println("img="+limg);
        String[] cstr = commentContent.split("&");
        List lgradle=JSON.parseArray(commentGradle);
        int num=0;
        for (int i=0;i<lspuid.size();i++){
            WphUserComment wphUserComment=new WphUserComment();
            wphUserComment.setCommentUserid(Integer.parseInt(userid));
            String Spuid=(String) lspuid.get(i);
            String[] str = spuid.split(":");
            Integer Ipuid = Integer.parseInt(str[1]);
            wphUserComment.setCommentSpuid(Ipuid);
            String Scontent=cstr[i];
            wphUserComment.setCommentContent(Scontent);
            Integer Sgradle=(Integer) lgradle.get(i);
            wphUserComment.setCommentGradle(Sgradle);
            wphUserComment.setComment_nowtime(DateUtil.SchangeD(DateUtil.getNowDate()));
            wphUserComment.setComment_orderid(orderid);
            Set<String> s = BadWordUtil2.words;
            Map<String, String> map = BadWordUtil2.wordMap;
            Set<String> set = BadWordUtil2.getBadWord(Scontent, 2);
            Boolean k = BadWordUtil2.isContaintBadWord(Scontent, 2);
            if (k == true) {
                System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
                return "500";
            } else {
                num=wphUserCommentDao.insertcomment(wphUserComment);
                if (num==0){
                    return "新增失败";
                }
            }
            if (limg!=null){
                List limg1=(List) limg.get(i);
                for (Object o:limg1){
                    Integer commentid=wphUserCommentDao.queryid(Ipuid,Integer.parseInt(userid),orderid);
                    String img1=(String) o;
                    commentimgDao.insert(commentid,img1);
                }
            }
        }
            return "新增成功";
    }
    @Override
    public Integer deleteBycommentId(Integer commentId) {
        return wphUserCommentDao.deleteBycommentId(commentId);
    }

    @Override
    public List querycount(Integer spuid) {
        List list=new ArrayList();
        list.add(wphUserCommentDao.querycount(spuid));
        list.add(wphUserCommentDao.querycount1(spuid));
        list.add(wphUserCommentDao.querycount2(spuid));
        list.add(wphUserCommentDao.querycount3(spuid));

        return list;
    }
}