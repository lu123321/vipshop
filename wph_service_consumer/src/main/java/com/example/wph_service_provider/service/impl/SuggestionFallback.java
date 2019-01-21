package com.example.wph_service_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_service_provider.entity.Suggestions;
import com.example.wph_service_provider.service.SuggestionService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class SuggestionFallback implements SuggestionService {
    @Override
    public String testRadio(String sugtype) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    @Override
    public String length(String sugtitle) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    @Override
    public String sugcontentLength(String sugcontent) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    @Override
    public String verifyPhoneAndEmail(String sugemail) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    @Override
    public String vrifyCode(String vrifyCode) {
        return JSON.toJSONString("服务出错，请稍后");
    }


    @Override
    public String submi(Suggestions suggestions, String vrifyCode) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    //用户通过id查看自己提交的建议
    //用户通过id和提交时间查看自己提交的建议
    //商家通过时间查看用户提交的建议
    //商家通过id查看特定用户提交的建议
    @Override
    public String queryAll(Suggestions suggestions,Integer index,Integer pageSzie) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    //用户通过uid和 creatTime 删除自己提交的反馈
    @Override
    public String deleteSugByUid(Integer uid, String creatTime) {
        return JSON.toJSONString("服务出错，请稍后");
    }


    //通过主键删除
    @Override
    public String deleteById(Integer sugid) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    //查询数据库总条数
    @Override
    public String titlePageCount() {
        return JSON.toJSONString("服务出错，请稍后");
    }

    //用户查看自己提交的反馈总条数
    @Override
    public String titleCountUser(Integer uid) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    //批量删除
    @Override
    public String deleteByManyIds(String str) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    //通过主键修改 单个修改
    //客服可以修改状态   用户可以修改自己提交的内容
    @Override
    public String update(Suggestions suggestions) {
        return JSON.toJSONString("服务出错，请稍后");
    }

    //用户查看提交的反馈
    @Override
    public String getAllByUid(Integer uid, Integer index, Integer pageSize) {
        return JSON.toJSONString("服务出错，请稍后");
    }


}
