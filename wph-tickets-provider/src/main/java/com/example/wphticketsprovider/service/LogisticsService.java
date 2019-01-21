package com.example.wphticketsprovider.service;

import com.example.wphticketsprovider.entity.Logistics;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * (Logistics)表服务接口
 *
 * @author makejava
 * @since 2018-12-27 14:51:13
 */
public interface LogisticsService {
    /**
     * 查询所有还没有完成的订每10小时跟新一次
     *
     */
    void queryAll();


    //修改订单状态
    String updateStates( String logisticcode, String state);

    //新增物流单号
    String insertLog( String shippercode, String logisticcode);

    //在自己本数据库通过订单号查询
    String  getByLogisticcode(String logisticcode);




//    /**
//     * 通过ID查询单条数据
//     *
//     * @param logid 主键
//     * @return 实例对象
//     */
//    Logistics queryById(Integer logid);
//
//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<Logistics> queryAllByLimit(int offset, int limit);
//
//
//
//
//    /**
//     * 新增数据
//     *
//     * @param logistics 实例对象
//     * @return 实例对象
//     */
//    Logistics insert(Logistics logistics);
//
//
//    /**
//     * 修改数据
//     *
//     * @param logistics 实例对象
//     * @return 实例对象
//     */
//    Logistics update(Logistics logistics);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param logid 主键
//     * @return 是否成功
//     */
//    boolean deleteById(Integer logid);

}