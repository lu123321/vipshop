package com.example.wph_service_provider.service;

import com.example.wph_service_provider.entity.Suggestions;
import com.example.wph_service_provider.service.impl.SuggestionFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "wph-service-provider",fallback = SuggestionFallback.class)
public interface SuggestionService {

    //测试redio
    @RequestMapping("/testRadio")
    public String testRadio(@RequestParam("sugtype") String sugtype);

    //判定字符长度
    @RequestMapping("/length")
    public String length(@RequestParam("sugtitle") String sugtitle);


    //判断输入内容长度
    @RequestMapping("/sugcontentLength")
    public String sugcontentLength(@RequestParam("sugcontent") String sugcontent);


    //判定输入的手机号或者邮箱
    @RequestMapping("/verifyPhoneAndEmail")
    public String verifyPhoneAndEmail(@RequestParam("sugemail") String sugemail);

    //判定图片校验码是否正确
    @RequestMapping("/vertifytupian")
    public String vrifyCode(@RequestParam("vrifyCode") String vrifyCode);


    @RequestMapping( "/submi")
    //如果参数是对象，在前面加一个@RequestBody
    public String submi(@RequestBody Suggestions suggestions,
                        @RequestParam("vrifyCode")String vrifyCode);


    //用户通过id查看自己提交的建议
    //用户通过id和提交时间查看自己提交的建议
    //商家通过时间查看用户提交的建议
    //商家通过id查看特定用户提交的建议
    @RequestMapping("queryAll")
    public String  queryAll(@RequestBody(required = false)Suggestions suggestions,
                            @RequestParam("index") Integer index,
                            @RequestParam("pageSize") Integer pageSize);


    //用户通过uid和 creatTime 删除自己提交的反馈
    @RequestMapping("deleteSugByUid")
    public String deleteSugByUid(@RequestParam("uid") Integer uid,
                                 @RequestParam("creatTime") String creatTime);


    //通过主键删除
    @RequestMapping("deleteById")
    public String  deleteById(@RequestParam("sugid") Integer sugid);


    //查询数据库总条数
    @RequestMapping("titlePageCount")
    public String titlePageCount();

    //用户查看自己提交的反馈总条数
    @RequestMapping("titleCountUser")
    public String titleCountUser(@RequestParam("uid") Integer uid);

    //批量删除
    @RequestMapping("deleteByManyIds")
    public String deleteByManyIds(@RequestParam("str") String str);

    //通过主键修改 单个修改
    //客服可以修改状态   用户可以修改自己提交的内容
    @RequestMapping("update")
    public String  update( Suggestions suggestions);


    //用户查看提交的反馈
    @RequestMapping("getAllByUid")
    public String getAllByUid(@RequestParam("uid") Integer uid,
                              @RequestParam("index") Integer index,
                              @RequestParam("pageSize") Integer pageSize);

}
