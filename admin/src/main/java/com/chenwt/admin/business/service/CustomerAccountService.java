package com.chenwt.admin.business.service;

import com.chenwt.admin.business.domain.entity.CustomerAccount;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CustomerAccountService {
    /**
     * 查找
     * @param customerId
     * @return
     */
    CustomerAccount findByCustomerId(Long customerId);

    /**
     * 保存
     * @param customerAccount
     */
    void save(CustomerAccount customerAccount);

    /**
     * userId 给customerId充值
     * @param userId
     * @param customerId
     * @param money
     */
    void payMoneyToAccount(Long userId,Long customerId, Double money);
}
