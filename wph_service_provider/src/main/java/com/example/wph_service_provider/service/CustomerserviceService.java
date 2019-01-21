package com.example.wph_service_provider.service;

import com.example.wph_service_provider.entity.Customerservice;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Customerservice)表服务接口
 *
 * @author makejava
 * @since 2018-12-20 14:18:52
 */
public interface CustomerserviceService {

    //通过问题类型查找具体的问题
    String findQuestionByType(String cstype);

    //通过具体问题找解决方案
    Customerservice findSolutionByQuestion(String csquestion);

//     //通过具体问题找解决方案
//    Customerservice  findSolutionByQuestion(String csquestion);

    /**
     * 通过ID查询单条数据
     *
     * @param csid 主键
     * @return 实例对象
     */
    Customerservice queryById(Integer csid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Customerservice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param customerservice 实例对象
     * @return 实例对象
     */
    Customerservice insert(Customerservice customerservice);

    /**
     * 修改数据
     *
     * @param customerservice 实例对象
     * @return 实例对象
     */
    Customerservice update(Customerservice customerservice);

    /**
     * 通过主键删除数据
     *
     * @param csid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer csid);

}