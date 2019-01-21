package com.example.wph_service_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_service_provider.entity.Suggestions;
import com.example.wph_service_provider.dao.SuggestionsDao;
import com.example.wph_service_provider.service.SuggestionsService;
import com.example.wph_service_provider.util.DateUtil;
import com.example.wph_service_provider.util.VerifyEmail;
import com.example.wph_service_provider.util.VertifyPhone;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Suggestions)表服务实现类
 *
 * @author makejava
 * @since 2018-12-19 19:37:55
 */
@Service("suggestionsService")
public class SuggestionsServiceImpl implements SuggestionsService {
    @Resource
    private SuggestionsDao suggestionsDao;

    //判定反馈类型
    @Override
    public String sugtypeLength(String sugtype) {
        String s ="";
        if (sugtype.equals("与订单相关")||sugtype.equals("购物问题 ")||sugtype.equals("账户问题/建议投诉")||sugtype.equals("其它")){
            return s="已选择";
        }else {
            return s="请选择反馈类型";
        }

    }

    //判定标题字符长度
    @Override
    public String length(String sugtitle) {
        String s ="";
        if(sugtitle.length() >= 4 &&sugtitle.length() <30){
            return s="输入正确";
        }else {
            return s="输入有误";
        }

    }

    //判断输入内容长度
    @Override
    public String sugcontentLength(String sugcontent) {
        String s ="";
        if (sugcontent.length()>=10 &&sugcontent.length()<=1000){
            return s="您还可以输入"+(1000-sugcontent.length()+"字");
        }else {
            return s="输入有误,最少输入10个字";
        }

    }

    //判定输入的手机号或者邮箱
    @Override
    public String verifyPhoneAndEmail(String sugemail) {
        String s ="";
        boolean mobile = VertifyPhone.isMobile(sugemail);
        boolean email = VerifyEmail.isEmail(sugemail);

        if (mobile ==true ||email == true){
            return s="输入正确";
        }else {
            return s="输入有误";
        }

    }

    //判定输入的图片校验码
    @Override
    public String vrifyCode(String vrifyCode) {
        Jedis jd = new Jedis("localhost", 6379);
        String vrifyCode1 = jd.get("vrifyCode");
        System.out.println(vrifyCode1 + "vrifyCode1");
        System.out.println(vrifyCode + "vrifyCode");
        if (vrifyCode1.equals(vrifyCode)) {
            return "输入正确";
        } else {
            return "验证码错误";
        }

    }

    //提交
    @Override
    public String submi(Suggestions suggestions,String vrifyCode) {
        //获得问题类型
        String sugtype = suggestions.getSugtype();
        String s1 = sugtypeLength(sugtype);

        //获得标题
        String sugtitle = suggestions.getSugtitle();
        String s2 = length(sugtitle);

        //获得手机号或者邮箱号
        String sugemail = suggestions.getSugemail();
        String s3 = verifyPhoneAndEmail(sugemail);

        //获得输入的内容
        String sugcontent = suggestions.getSugcontent();
        String s4 = sugcontentLength(sugcontent);

        //获得图片校验码
        Jedis jd = new Jedis("localhost", 6379);
        String vrifyCode1 = jd.get("vrifyCode");

        //获取当前时间插入
        String nowDate = DateUtil.getNowDate();
        System.out.println(nowDate+"当前时间");
        suggestions.setCreatTime(nowDate);

        //插入时顺便把状态插进去  刚开始为0
        suggestions.setC1(0);

        //提交之前先查查今天交了几次，防止垃圾信息大量注入
        Integer uid = suggestions.getUid();
        Suggestions ss = new Suggestions();
        ss.setUid(uid);
        ss.setCreatTime(nowDate);
        List<Suggestions> suggestions1 = suggestionsDao.queryAll(ss);
        System.out.println(suggestions1.size()+"集合长度");
        if (suggestions1.size() >4){
            return "您今天提交的次数超限，请明天再提交";
        }else {
            if ((s1.equals("已选择"))&&(s2.equals("输入正确"))
                    &&(!s4.equals("输入有误,最少输入10个字"))
                    &&(s3.equals("输入正确"))&&(vrifyCode1.equals(vrifyCode))){
                int insert = suggestionsDao.insert(suggestions);
                return "提交成功";
            }else {
                return "提交失败，请重新提交";
            }
        }



    }


    //用户通过id查看自己提交的建议
    //用户通过id和提交时间查看自己提交的建议
    //后台通过时间查看用户提交的建议
    //后台通过id查看特定用户提交的建议
    //后台查看全部反馈
    @Override
    public List<Suggestions> queryAll(Suggestions suggestions,Integer index,Integer pageSize) {
        //这里一定要注意这个分页一定要写在查到的东西上面
        //这里一定要注意这个分页一定要写在查到的东西上面
        //这里一定要注意这个分页一定要写在查到的东西上面
        //这里一定要注意这个分页一定要写在查到的东西上面
        //这里一定要注意这个分页一定要写在查到的东西上面
        PageHelper.startPage(index,pageSize);
        List<Suggestions> suggestions1 = suggestionsDao.queryAll(suggestions);
        return suggestions1;
    }


    //用户通过uid和 creatTime 删除自己提交的反馈
    @Override
    public String deleteSugByUid(Integer uid,String creatTime) {
        int i = suggestionsDao.deleteSugByUid(uid,creatTime);
        if (i >0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }


    //通过主键删除(单个删除）
    @Override
    public String  deleteById(Integer sugid) {
        int i = this.suggestionsDao.deleteById(sugid);
        if (i >0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }






    //用户查询两个时间点之间的数据+分页
    @Override
    public List<Suggestions> getBetween(Integer index, Integer pageSize,String creatTime1,String creatTime2) {
        List<Suggestions> between = suggestionsDao.getBetween(creatTime1, creatTime2);
        PageHelper.startPage(index,pageSize);
        return between;
    }

    //查询数据库总条数
    @Override
    public Integer titlePageCount() {
        Integer i = suggestionsDao.titlePageCount();

        return i;
    }

    //用户查看自己提交的反馈总条数
    @Override
    public Integer titleCountUser(Integer uid) {
        int i = suggestionsDao.titleCountUser(uid);
        return i;
    }

    //批量删除
    @Override
    public String deleteByManyIds(String str) {
        //前台传来多个id，以逗号隔开。这里把逗号去掉
        String[] s = str.split(",");
        Integer num = null;
        for (int i = 0; i < s.length; i++){
            //把所有的字符id转换成数字，才能运算
            Integer inte = Integer.valueOf(s[i]);
            System.out.println(inte+"inte");
            int j = suggestionsDao.deleteById(inte);
            //反过来想，只要有一个没有删除成功，就跳出
            if (j == 0){
                //给num赋值
                num = 0;
                break;
            }else {
                num = 1;
            }
        }


        if ( num ==1){
            return "删除成功";
        }else {
            return "删除失败";
        }

    }

    //通过主键修改 单个修改
    @Override
    public String  update(Suggestions suggestions) {
        int update = suggestionsDao.update(suggestions);
        if (update >0){
            return "修改成功";
        }else {
            return "修改失败";
        }

    }

    //用户查看提交的反馈
    @Override
    public PageInfo getAllByUid(Integer uid,Integer index,Integer pageSize) {
        PageHelper.startPage(index,pageSize);
        List<Suggestions> allByUid = suggestionsDao.getAllByUid(uid);
        PageInfo p = new PageInfo(allByUid);
        return p;
    }


    /**
     * 通过ID查询单条数据
     *
     * @param sugid 主键
     * @return 实例对象
     */
    @Override
    public Suggestions queryById(Integer sugid) {
        return this.suggestionsDao.queryById(sugid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Suggestions> queryAllByLimit(int offset, int limit) {
        return this.suggestionsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param suggestions 实例对象
     * @return 实例对象
     */
    @Override
    public Suggestions insert(Suggestions suggestions) {
        this.suggestionsDao.insert(suggestions);
        return suggestions;
    }





}