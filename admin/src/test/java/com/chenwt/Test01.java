package com.chenwt;

import com.chenwt.admin.business.domain.entity.Customer;
import com.chenwt.admin.business.repository.CustomerRepository;
import com.chenwt.common.data.PageSort;
import com.chenwt.modules.system.service.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @class：Test01
 * @campany：zkzj
 * @author:feiniaoying
 * @date:2019-05-04 21:20
 * @description:
 */
public class Test01 extends BaseTest {
    @Autowired
    private RoleService roleService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test01(){
        // 创建分页对象
        Pageable page = PageSort.pageRequest(Sort.Direction.ASC);
    }
}
