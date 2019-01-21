package com.example.wph_service_provider.controller;

import com.alibaba.fastjson.JSON;
import com.example.wph_service_provider.entity.Suggestions;
import com.example.wph_service_provider.service.SuggestionService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
public class SuggestionController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private SuggestionService ss;

    //测试redio
    @RequestMapping("/testRadio")
    public String testRadio(String sugtype, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.testRadio(sugtype);
    }

    //判定标题字符长度
    @RequestMapping("/length")
    public String length(String sugtitle, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.length(sugtitle);
    }

    //判断输入内容长度
    @RequestMapping("/sugcontentLength")
    public String sugcontentLength(String sugcontent, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.sugcontentLength(sugcontent);
    }

    //判定输入的手机号或者邮箱
    @RequestMapping("/verifyPhoneAndEmail")
    public String verifyPhoneAndEmail(String sugemail, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.verifyPhoneAndEmail(sugemail);
    }

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.addHeader("Access-Control-Allow-Origin","*");
        //声明一个数组
        byte[] captchaChallengeAsJpeg = null;
        //数组输出流
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生成验证码字符串（text)并保存到redis中,下面要往出拿
            String createText = defaultKaptcha.createText();
            //保存到redis中
            Jedis jd = new Jedis("localhost", 6379);
            jd.flushAll();
            jd.set("vrifyCode", createText);
            System.out.println("放进去的验证码" + jd.get("vrifyCode"));
            //使用生成的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            //设置以"jpg"的格式
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            //SC_NOT_FOUND=404
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();


        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }


    //判定图片校验码是否正确;
    @RequestMapping("/vertifytupian")
    public String vrifyCode(@RequestParam("vrifyCode") String vrifyCode, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.vrifyCode(vrifyCode);
    }

    //提交
    @RequestMapping("/subbb")
    public String submi(Suggestions suggestions, String vrifyCode, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.submi(suggestions,vrifyCode);
    }


    @RequestMapping("/failer")
    public String failer(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return JSON.toJSONString("注册失败");
    }

    //用户通过id查看自己提交的建议
    //用户通过id和提交时间查看自己提交的建议
    //商家通过时间查看用户提交的建议
    //商家通过id查看特定用户提交的建议
    @RequestMapping("queryAll")
    public String  queryAll(Suggestions suggestions,
                            @RequestParam("index") Integer index,
                            @RequestParam("pageSize") Integer pageSize,HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        System.out.println(pageSize+"总页数");
        System.out.println(index+"页码");
        System.out.println(suggestions.getSugtitle());
        return ss.queryAll(suggestions, index,pageSize);
    }

    //用户通过uid和 creatTime 删除自己提交的反馈
    @RequestMapping("deleteSugByUid")
    public String deleteSugByUid(Integer uid,String creatTime,HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.deleteSugByUid(uid,creatTime);
    }


    //通过主键删除
    @RequestMapping("deleteById")
    public String  deleteById(Integer sugid,HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.deleteById(sugid);
    }


    //查询数据库总条数
    @RequestMapping("titlePageCount")
    public String titlePageCount(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.titlePageCount();
    }

    //用户查看自己提交的反馈总条数
    @RequestMapping("titleCountUser")
    public String titleCountUser(Integer uid,HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.titleCountUser(uid);
    }

    //批量删除
    @RequestMapping("deleteByManyIds")
    public String deleteByManyIds( String str,HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.deleteByManyIds(str);
    }



    //通过主键修改 单个修改
    //客服可以修改状态   用户可以修改自己提交的内容
    @RequestMapping("update")
    public String  update(@RequestBody(required = false) Suggestions suggestions,HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.update(suggestions);
    }

    //用户查看提交的反馈
    @RequestMapping("getAllByUid")
    public String getAllByUid(Integer uid,
                              Integer index,
                             Integer pageSize,HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return ss.getAllByUid(uid, index, pageSize);
    }
}
