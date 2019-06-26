package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.entity.CustomerAccount;
import com.chenwt.admin.business.repository.CustomerAccountRepository;
import com.chenwt.admin.business.service.CustomerAccountService;
import com.chenwt.common.enums.StatusEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @class：OrderServiceImpl
 * @campany：zkzj
 * @author:feiniaoying
 * @date:2019-05-06 01:21
 * @description:
 */
@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {
    @Resource
    private CustomerAccountRepository customerAccountRepository;

    @Override
    public CustomerAccount findByCustomerId(Long customerId) {
        return customerAccountRepository.findByCustomerId(customerId);
    }

    @Override
    public void save(CustomerAccount customerAccount) {
        customerAccountRepository.save(customerAccount);
    }

    @Override
    public void payMoneyToAccount(Long userId, Long customerId, Double money) {
        CustomerAccount customerAccount = findByCustomerId(customerId);
        if (null != customerAccount){
            customerAccount.setMoney(customerAccount.getMoney()+money);
            customerAccount.setUpdateBy(userId);
            customerAccount.setUpdateDate(new Date());
        }else{
            customerAccount = new CustomerAccount();
            customerAccount.setCustomerId(customerId);
            customerAccount.setMoney(money);
            customerAccount.setCreateBy(userId);
            customerAccount.setCreateDate(new Date());
            customerAccount.setStatus(StatusEnum.OK.getCode());
        }
        save(customerAccount);
    }
}
