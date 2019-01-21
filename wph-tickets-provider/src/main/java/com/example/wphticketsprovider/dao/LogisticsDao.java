package com.example.wphticketsprovider.dao;

import com.example.wphticketsprovider.entity.Logistics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Logistics)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-27 14:51:13
 */
@Repository
@Mapper
public interface LogisticsDao {



    /**
     * 查询所有还没有完成的订单
     */
    @Select("select shippercode,logisticcode from logistics where state = 3")
    List<Logistics> queryAll();

    //修改订单物流信息
    @Update("update logistics  set traces = #{traces} where logisticcode = #{logisticcode}")
    int updateTraces(@Param("logisticcode") String logisticcode,
                     @Param("traces") String traces);

    //修改订单状态
    @Update("update logistics  set state = #{state} where logisticcode = #{logisticcode}")
    int updateStates(@Param("logisticcode") String logisticcode,
                     @Param("state") String state);

    //新增物流单号
    @Insert("insert into logistics (shippercode,logisticcode) values (#{shippercode},#{logisticcode})")
    int insertLog(@Param("shippercode") String shippercode,
                  @Param("logisticcode") String logisticcode);

    //在自己本数据库通过订单号查
    @Select("select traces from logistics where logisticcode = #{logisticcode}")
    Logistics getByLogisticcode(String logisticcode);







//
//    /**
//     * 通过ID查询单条数据
//     *
//     * @param logid 主键
//     * @return 实例对象
//     */
//    Logistics queryById(Integer logid);
//
//    /**
//     * 查询指定行数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<Logistics> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
//
//
//
//
//    /**
//     * 新增数据
//     *
//     * @param logistics 实例对象
//     * @return 影响行数
//     */
//    int insert(Logistics logistics);
//
//    /**
//     * 修改数据
//     *
//     * @param logistics 实例对象
//     * @return 影响行数
//     */
//    int update(Logistics logistics);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param logid 主键
//     * @return 影响行数
//     */
//    int deleteById(Integer logid);

}