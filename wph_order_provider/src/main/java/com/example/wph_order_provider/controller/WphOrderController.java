package com.example.wph_order_provider.controller;

import com.alibaba.fastjson.JSON;
import com.example.wph_order_provider.service.WphOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (WphOrder)表控制层
 *
 * @author makejava
 * @since 2018-12-19 09:15:13
 */
@RestController
public class WphOrderController {
    /**
     * 服务对象
     */
    @Autowired
    private WphOrderService wphOrderService;

    /**
     * 通过主键查询单条数据
     * @param orderId 订单id
     * @return 单条数据
     */
    @PostMapping("/selectOne")
    public String selectOne(@RequestParam("orderId") Integer orderId,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        return JSON.toJSONString(wphOrderService.queryById(orderId));
    }

    @PostMapping("/add")
    public String add(@RequestParam("ordershoping")String ordershoping,@RequestParam("money")double money,@RequestParam("orderadress")String orderadress,HttpServletRequest request){
        String userid=request.getHeader("userid");
        return wphOrderService.insert(Integer.parseInt(userid), ordershoping, money, orderadress);
    }

    @PostMapping("/update")
    public String update(@RequestParam("orderno") String orderno,@RequestParam("orderstate")Integer orderstate,@RequestParam("orderpaynumber")String orderpaynumber,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        System.out.println("orderno = [" + orderno + "], orderstate = [" + orderstate + "], orderpaynumber = [" + orderpaynumber + "]");
        if(orderpaynumber==""){
            orderpaynumber=null;
        }
        return wphOrderService.update(orderno,orderstate,orderpaynumber);
    }

    @PostMapping("/update7")
    public Integer update7(HttpServletResponse response,@RequestParam("orderid")Integer orderid){
        response.setHeader("Access-Control-Allow-Origin","*");
        return wphOrderService.update7(orderid);
    }

    @PostMapping("/orderdel")
    public String del(@RequestParam("orderid")Integer orderid,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        return wphOrderService.deleteById(orderid);
    }

    @PostMapping("/selall")
    public String selpage( @RequestParam("pagenum")Integer pagenum,@RequestParam("state")Integer state, HttpServletRequest request){
        String userid=request.getHeader("userid");
        return JSON.toJSONString(wphOrderService.queryAll(Integer.parseInt(userid), pagenum,state));
    }

    @PostMapping("/querycountbyorder")
    String querycountbyorder(HttpServletRequest request){
        String userid=request.getHeader("userid");
        return JSON.toJSONString(wphOrderService.querycountbyorder(Integer.parseInt(userid)));
    }

    /**
     * 后台查看订单状态
     * @return
     */
    @PostMapping("/selstate")
    public String selstate(HttpServletResponse response,@RequestParam("pagenum") Integer pagenum){
        response.setHeader("Access-Control-Allow-Origin","*");
        return wphOrderService.selstate(pagenum);
    }

    /**
     * 后台查看订单状态
     * @return
     */
    @PostMapping("/seluserstate")
    public String seluserstate(HttpServletResponse response,@RequestParam("userid")Integer userid,@RequestParam("pagenum") Integer pagenum){
        response.setHeader("Access-Control-Allow-Origin","*");
        return JSON.toJSONString(wphOrderService.seluserstate(userid,pagenum));
    }

    /**
     * 后台发货
     * @return
     */
    @PostMapping("/updatestate")
    public int updatestate(@RequestParam("orderwaybill")String orderwaybill,@RequestParam("orderid")Integer orderid){
        return wphOrderService.updatestate(orderwaybill,orderid);
    }

    /**
     * 前台查看退货
     * @return
     */
    @PostMapping("/seltuihuo")
    public String seltuihuo(HttpServletRequest request,@RequestParam("pagenum")Integer pagenum,@RequestParam("state")Integer state){
        String userid = request.getHeader("userid");
        return JSON.toJSONString(wphOrderService.seltuihuo(Integer.parseInt(userid),pagenum,state));
    }
    @PostMapping("/querycountbytuihuo")
    String querycountbytuihuo(HttpServletRequest request){
        String userid = request.getHeader("userid");
        return JSON.toJSONString(wphOrderService.querycountbytuihuo(Integer.parseInt(userid)));
    }
    /**
     * 后台查询申请退货
     * @return
     */
    @PostMapping("/hseltuihuo")
    public String hseltuihuo(HttpServletResponse response,@RequestParam("pagenum") Integer pagenum){
        response.setHeader("Access-Control-Allow-Origin","*");
        return JSON.toJSONString(wphOrderService.hseltuihuo(pagenum));
    };

    /**
     * 后台允许退货
     * @param orderid
     * @return
     */
    @PostMapping("/updatetuihuo")

    int updatetuihuo(HttpServletResponse response,@RequestParam("orderid") Integer orderid,@RequestParam("paynumber") String paynumber){
        response.setHeader("Access-Control-Allow-Origin","*");
        return wphOrderService.updatetuihuo(orderid,paynumber);
    };
    /**
     * 后台不允许退货
     * @param orderid
     * @return
     */
    @PostMapping("/updatetuihuoshibai")
    int updatetuihuoshibai(@RequestParam("state") Integer state,@RequestParam("shibai") String shibai,@RequestParam("orderid") Integer orderid){
        return wphOrderService.updatetuihuoshibai(state, shibai, orderid);
    };

    @PostMapping("queryAllByshoping")
    String queryAllByshoping(@RequestParam("pagenum")Integer pagenum,@RequestParam("spuid")Integer spuid,HttpServletResponse response,@RequestParam("state") Integer state){
        response.setHeader("Access-Control-Allow-Origin","*");
        return  wphOrderService.queryAllByshoping(pagenum,spuid,state);
    };

    @PostMapping("hqueryAllByshoping")
    String hqueryAllByshoping(){
        return JSON.toJSONString(wphOrderService.hqueryAllByshoping());
    };

    @PostMapping("updatecomment")
    Integer updatecomment(@RequestParam("commentHuifu")String commentHuifu,@RequestParam("commentId")Integer commentId){
        return wphOrderService.updatecomment(commentHuifu, commentId);
    };

    @PostMapping("insertcomment")
    String insertcomment(@RequestParam("userid")String userid, @RequestParam("spuid")String spuid, @RequestParam("img")String img, @RequestParam("commentContent")String commentContent, @RequestParam("commentGradle")String commentGradle, @RequestParam("orderid") Integer orderid, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        return wphOrderService.insertcomment(userid, spuid, img, commentContent, commentGradle,orderid);
    };

    @PostMapping("deleteBycommentId")
    Integer deleteBycommentId(@RequestParam("commentId") Integer commentId){
        return wphOrderService.deleteBycommentId(commentId);
    };

    @PostMapping("querycount")
    public String querycount(@RequestParam("spuid")Integer spuid,HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin","*");
        return JSON.toJSONString(wphOrderService.querycount(spuid));
    }
}