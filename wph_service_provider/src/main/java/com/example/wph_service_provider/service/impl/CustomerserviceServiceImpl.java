package com.example.wph_service_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_service_provider.entity.Customerservice;
import com.example.wph_service_provider.dao.CustomerserviceDao;
import com.example.wph_service_provider.service.CustomerserviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Customerservice)表服务实现类
 *
 * @author makejava
 * @since 2018-12-20 14:18:52
 */
@Service
public class CustomerserviceServiceImpl implements CustomerserviceService {
    @Resource
    private CustomerserviceDao customerserviceDao;

    @Override
    public String findQuestionByType(String cstype) {

        //通过类型查具体问题
        List<Customerservice> questionByType = customerserviceDao.findQuestionByType(cstype);
        return JSON.toJSONString(questionByType);
    }

//    //通过具体问题找解决方案
//    @Override
//    public Customerservice findSolutionByQuestion(String csquestion) {
//        return customerserviceDao.findSolutionByQuestion(csquestion);
//    }

    //通过具体问题找解决方案
    @Override
    public Customerservice findSolutionByQuestion(String csquestion) {
        Customerservice solutionByQuestion = customerserviceDao.findSolutionByQuestion(csquestion);
        return solutionByQuestion;
    }



    /**
     * 通过ID查询单条数据
     *
     * @param csid 主键
     * @return 实例对象
     */
    @Override
    public Customerservice queryById(Integer csid) {
        return this.customerserviceDao.queryById(csid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Customerservice> queryAllByLimit(int offset, int limit) {
        return this.customerserviceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param customerservice 实例对象
     * @return 实例对象
     */
    @Override
    public Customerservice insert(Customerservice customerservice) {
        this.customerserviceDao.insert(customerservice);
        return customerservice;
    }

    /**
     * 修改数据
     *
     * @param customerservice 实例对象
     * @return 实例对象
     */
    @Override
    public Customerservice update(Customerservice customerservice) {
        this.customerserviceDao.update(customerservice);
        return this.queryById(customerservice.getCsid());
    }

    /**
     * 通过主键删除数据
     *
     * @param csid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer csid) {
        return this.customerserviceDao.deleteById(csid) > 0;
    }
}