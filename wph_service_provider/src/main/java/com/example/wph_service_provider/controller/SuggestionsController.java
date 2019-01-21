package com.example.wph_service_provider.controller;

import com.alibaba.fastjson.JSON;
import com.example.wph_service_provider.entity.Suggestions;
import com.example.wph_service_provider.service.SuggestionsService;
//import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * (Suggestions)表控制层
 *
 * @author makejava
 * @since 2018-12-19 19:37:55
 */
@RestController
public class SuggestionsController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    /**
     * 服务对象
     */
    @Resource
    private SuggestionsService suggestionsService;


    //测试redio
    @RequestMapping("/testRadio")
    public String testRadio(String sugtype){
        System.out.println(sugtype+"");
        String s = suggestionsService.sugtypeLength(sugtype);
        return JSON.toJSONString(s);
    }



    //判定字符长度
    @RequestMapping("/length")
    public String length(String sugtitle){
        System.out.println(sugtitle+"字符长度");
        String length = suggestionsService.length(sugtitle);
        return  JSON.toJSONString(length);
    }

    //判断输入内容长度
    @RequestMapping("/sugcontentLength")
    public String sugcontentLength(String sugcontent){
        System.out.println(sugcontent+"输入内容长度");
        String s = suggestionsService.sugcontentLength(sugcontent);
        return JSON.toJSONString(s);

    }

    //判定输入的手机号或者邮箱
    @RequestMapping("/verifyPhoneAndEmail")
    public String verifyPhoneAndEmail(String sugemail){
        System.out.println(sugemail+"手机号或者邮箱");
        String s = suggestionsService.verifyPhoneAndEmail(sugemail);
        return JSON.toJSONString(s);

    }

    //判定图片校验码是否正确
    @RequestMapping("/vertifytupian")
    public String vrifyCode(String vrifyCode){
        String s = suggestionsService.vrifyCode(vrifyCode);
        return JSON.toJSONString(s);
    }


    //用户提交建议
    @RequestMapping("/submi")
    public String submi( @RequestBody Suggestions suggestions,String vrifyCode){
        System.out.println(suggestions.getUid()+"这是id");
        String submi = suggestionsService.submi(suggestions,vrifyCode);
        return JSON.toJSONString(submi);

    }


    //用户通过id查看自己提交的建议
    //用户通过id和提交时间查看自己提交的建议
    //商家通过时间查看用户提交的建议
    //商家通过id查看特定用户提交的建议
    @RequestMapping("queryAll")
    public String  queryAll(@RequestBody(required = false)Suggestions suggestions,
                            @RequestParam("index") Integer index,
                            @RequestParam("pageSize") Integer pageSize) {
        List<Suggestions> suggestions1 = suggestionsService.queryAll(suggestions,index,pageSize);
        return JSON.toJSONString(suggestions1);
    }


    //用户通过uid和 creatTime 删除自己提交的反馈
    @RequestMapping("deleteSugByUid")
    public String deleteSugByUid(Integer uid,String creatTime){
        String s = suggestionsService.deleteSugByUid(uid, creatTime);
        return JSON.toJSONString(s);
    }

    //通过主键删除
    @RequestMapping("deleteById")
    public String  deleteById(Integer sugid){
        String s = suggestionsService.deleteById(sugid);
        return JSON.toJSONString(s);
    }

    //用户查询两个时间点之间的数据+分页
    @RequestMapping("getBetween")
    public String getBetween(Integer index, Integer pageSize, String creatTime1, String creatTime2) {
        List<Suggestions> between = suggestionsService.getBetween(index, pageSize, creatTime1, creatTime2);
        return JSON.toJSONString(between);
    }


    //查询数据库总条数
    @RequestMapping("titlePageCount")
    public String titlePageCount(){
        int i = suggestionsService.titlePageCount();
        return JSON.toJSONString(i);
    }


    //用户查看自己提交的反馈总条数
    @RequestMapping("titleCountUser")
    public String titleCountUser(Integer uid){
        Integer integer = suggestionsService.titleCountUser(uid);
        return JSON.toJSONString(integer);
    }

    //批量删除
    @RequestMapping("deleteByManyIds")
    public String deleteByManyIds(String str){
        String s = suggestionsService.deleteByManyIds(str);
        return JSON.toJSONString(s);
    }


    //通过主键修改 单个修改
    //客服可以修改状态   用户可以修改自己提交的内容
    @RequestMapping("update")
    public String  update(  Suggestions suggestions){
        String update = suggestionsService.update(suggestions);
        return JSON.toJSONString(update);
    }

    //用户查看提交的反馈
    @RequestMapping("getAllByUid")
    public String getAllByUid(int uid,int index,int pageSize){
        PageInfo allByUid = suggestionsService.getAllByUid(uid, index, pageSize);
        return  JSON.toJSONString(allByUid);
    }
}