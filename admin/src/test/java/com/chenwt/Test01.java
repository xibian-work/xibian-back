package com.chenwt;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * @class：Test01
 * @campany：zkzj
 * @author:feiniaoying
 * @date:2019-05-04 21:20
 * @description:
 */
public class Test01 extends BaseTest {
    @Value("${project.ke-url}")
    private String keUrl;

    @Test
    public void test01(){
        // 创建分页对象
        System.out.println(keUrl+"?customerId=");
    }
}
