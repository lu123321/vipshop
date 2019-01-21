package com.example.wphticketsprovider.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.wphticketsprovider.entity.Logistics;
import com.example.wphticketsprovider.dao.LogisticsDao;
import com.example.wphticketsprovider.service.LogisticsService;
import com.example.wphticketsprovider.util.KdniaoTrackQueryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Logistics)表服务实现类
 *
 * @author makejava
 * @since 2018-12-27 14:51:13
 */
@Service("logisticsService")
public class LogisticsServiceImpl implements LogisticsService {
    @Resource
    private LogisticsDao logisticsDao;

    @Autowired
    private KdniaoTrackQueryAPI kdniaoTrackQueryAPI;


    //查询所有还没有完成的订每10小时跟新一次
    @Scheduled(cron = "0 0 0-10 * * ? ")
    @Override
    public void queryAll() {
        List<Logistics> logistics1 = logisticsDao.queryAll();
         for (int i =0; i <logistics1.size(); i ++ ){
             //获得订单编号
             String logisticcode = logistics1.get(i).getLogisticcode();
             //获得公司编号
             String shippercode = logistics1.get(i).getShippercode();
             //通过快递公司名和订单编号查询订单轨迹
             try {
                 String orderTracesByJson = kdniaoTrackQueryAPI.getOrderTracesByJson(shippercode, logisticcode);
                 logisticsDao.updateTraces(logisticcode,orderTracesByJson);
             } catch (Exception e) {
                 e.printStackTrace();
             }
             System.out.println("hasfjaspdfaspdf");

         }

    }

    //修改订单状态
    @Override
    public String updateStates(String logisticcode, String state) {
        int i = logisticsDao.updateStates(logisticcode, state);
        String s ="";
        if (i >0){
            return s ="修改成功";
        }else {
            return s ="修改失败";
        }
    }

    //新增物流单号
    @Override
    public String insertLog(String shippercode, String logisticcode) {
        int i = logisticsDao.insertLog(shippercode, logisticcode);
        String s ="";
        if (i >0){
            return s ="新增成功";
        }else {
            return s ="新增失败";
        }
    }

    //在自己本数据库通过订单号查询
    @Override
    public String  getByLogisticcode(String logisticcode) {
        Logistics byLogisticcode = logisticsDao.getByLogisticcode(logisticcode);
        if (byLogisticcode !=null){
            //这里得到一个json，需要解析一下
            String s =byLogisticcode.getTraces();
            Map maps = (Map)JSON.parse(s);
            Object traces = maps.get("Traces");
            System.out.println(traces+"aaaaaaaaaaaaa");
            return JSON.toJSONString(traces);
        }else {
            return JSON.toJSONString("暂时没有订单轨迹");
        }

    }


//    /**
//     * 通过ID查询单条数据
//     *
//     * @param logid 主键
//     * @return 实例对象
//     */
//    @Override
//    public Logistics queryById(Integer logid) {
//        return this.logisticsDao.queryById(logid);
//    }
//
//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    @Override
//    public List<Logistics> queryAllByLimit(int offset, int limit) {
//        return this.logisticsDao.queryAllByLimit(offset, limit);
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param logistics 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public Logistics insert(Logistics logistics) {
//        this.logisticsDao.insert(logistics);
//        return logistics;
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param logistics 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public Logistics update(Logistics logistics) {
//        this.logisticsDao.update(logistics);
//        return this.queryById(logistics.getLogid());
//    }
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param logid 主键
//     * @return 是否成功
//     */
//    @Override
//    public boolean deleteById(Integer logid) {
//        return this.logisticsDao.deleteById(logid) > 0;
//    }
}