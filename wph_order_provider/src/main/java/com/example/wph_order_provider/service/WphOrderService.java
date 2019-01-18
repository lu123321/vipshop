package com.example.wph_order_provider.service;

import com.example.wph_order_provider.entity.OrderShoping;
import com.example.wph_order_provider.entity.WphOrder;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (WphOrder)表服务接口
 *
 * @author makejava
 * @since 2018-12-19 09:15:12
 */
public interface WphOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    List<OrderShoping> queryById(Integer orderid);


    /**
     * 新增订单
     * @param id 用户id
     * @param ordershoping 商品编号
     * @param money 总价
     */
    String insert(Integer id,String ordershoping,double money,String orderadress);


    /**
     * 修改数据
     *
     * @param orderno 订单编号
     * @param orderState
     * @return 实例对象
     */
    String update(String orderno,Integer orderState,String orderpaynumber);

    int update7(Integer orderid);


    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    String deleteById(Integer orderId);

    /**
     * 查全部订单
     * @return
     */
    String queryAll(Integer userid,Integer pagenum,Integer state);

    List querycountbyorder(Integer userid);
    /**
     * 后台查看订单状态
     * @return
     */
    String selstate(Integer pagenum);

    /**
     * 后台查看订单状态
     * @return
     */
    String seluserstate(Integer userid,Integer pagenum);

    /**
     * 后台发货
     * @return
     */
    int updatestate(String orderwaybill,Integer orderid);

    /**
     * 后台查询申请退货
     * @return
     */
    PageInfo hseltuihuo(Integer pagenum);

    /**
     * 前台用户查看自己申请的退货
     * @param userid
     * @return
     */
    String seltuihuo(Integer userid,Integer pagenum,Integer state);

    List querycountbytuihuo(Integer userid);
    /**
     * 后台允许退货
     * @param orderid
     * @return
     */
    int updatetuihuo(Integer orderid,String paynumber);


    int updatetuihuoshibai(Integer state,String shibai,Integer orderid);

    String queryAllByshoping(Integer pagenum,Integer spuid,Integer state);

    List hqueryAllByshoping();

    Integer updatecomment(String commentHuifu,Integer commentId);

    String insertcomment(String userid,String spuid,String img,String commentContent,String commentGradle,Integer orderid);

    Integer deleteBycommentId(Integer commentId);

    List querycount(Integer spuid);
}