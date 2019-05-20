package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.entity.CustomerMarketing;
import com.chenwt.admin.business.repository.CustomerMarketingRepository;
import com.chenwt.admin.business.service.CustomerMarketingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @class：OrderServiceImpl
 * @campany：zkzj
 * @author:feiniaoying
 * @date:2019-05-06 01:21
 * @description:
 */
@Service
public class CustomerMarketingServiceImpl implements CustomerMarketingService {
    @Resource
    private CustomerMarketingRepository customerMarketingRepository;

    @Override
    public CustomerMarketing findByCustomerIdAndType(Long customerId, Integer type) {
        return customerMarketingRepository.findByCustomerIdAndType(customerId,type);
    }

    @Override
    public void save(CustomerMarketing customerMarketing) {
        customerMarketingRepository.save(customerMarketing);
    }
}
