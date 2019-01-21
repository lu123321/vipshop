package com.example.wphticketsprovider;

import com.example.wphticketsprovider.entity.Coupons;
import com.example.wphticketsprovider.service.CadService;
import com.example.wphticketsprovider.service.CouponsService;
import com.example.wphticketsprovider.service.LogisticsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WphTicketsProviderApplicationTests {

    @Autowired
    private CouponsService couponsService;
    @Autowired
    private CadService cadService;
    @Autowired
    private LogisticsService logisticsService;

    @Test
    public void contextLoads() {

        String byLogisticcode = logisticsService.getByLogisticcode("640070137982");
        System.out.println(byLogisticcode);

    }

}

