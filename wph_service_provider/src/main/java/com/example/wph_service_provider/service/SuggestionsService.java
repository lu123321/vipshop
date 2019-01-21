package com.example.wph_service_provider.service;

import com.example.wph_service_provider.entity.Suggestions;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Suggestions)表服务接口
 *
 * @author makejava
 * @since 2018-12-19 19:37:55
 */
public interface SuggestionsService {

    //判定有没有选择反馈类型
    String sugtypeLength(String sugtype);

    //判断标题字符长度
    String length(String sugtitle);

    //判断输入内容长度
    String sugcontentLength(String sugcontent);

    //判定输入的手机号或者邮箱
    String  verifyPhoneAndEmail(String sugemail);

    // 判定输入的图片验证码
   public String vrifyCode(String vrifyCode);

    //提交
    String  submi(Suggestions suggestions,String vrifyCode);

    //新增所有数据
    Suggestions insert(Suggestions suggestions);


    //用户通过id查看自己提交的建议
    //用户通过id和提交时间查看自己提交的建议
    //商家通过时间查看用户提交的建议
    //商家通过id查看特定用户提交的建议
    List<Suggestions> queryAll(Suggestions suggestions,Integer index,Integer pageSize);

    //用户通过uid和 creatTime 删除自己提交的反馈
    String deleteSugByUid(Integer uid,String creatTime);

    //通过主键sugid删除   单个删除
    String  deleteById(Integer sugid);

    //用户查询两个时间点之间的数据+分页
    List<Suggestions> getBetween(Integer index,Integer pageSize,String creatTime1,String creatTime2);

    //查询数据库总条数
    Integer titlePageCount();

    //用户查看自己提交的反馈总条数
    Integer titleCountUser(Integer uid);

    //批量删除
    String deleteByManyIds(String str);

    //通过主键修改   单个修改
    String update(Suggestions suggestions);

    //用户查看提交的反馈
   PageInfo getAllByUid(Integer uid,Integer index,Integer pageSize);

    //批量修改



    /**
     * 通过ID查询单条数据
     *
     * @param sugid 主键
     * @return 实例对象
     */
    Suggestions queryById(Integer sugid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Suggestions> queryAllByLimit(int offset, int limit);










}