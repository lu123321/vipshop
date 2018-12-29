package com.example.wph_shopcar_provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WphShopcarProviderApplicationTests {

    @Test
    public void contextLoads() {
        int i=0,k=10;
        while (k-->0){
            i=i++;
        }
        System.out.println(i);
    }
}

