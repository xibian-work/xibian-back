package com.chenwt.admin.business.service;

import com.chenwt.admin.business.domain.entity.CustomerMarketing;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CustomerMarketingService {
    /**
     * 查询
     * @param customerId
     * @param type
     * @return
     */
    CustomerMarketing findByCustomerIdAndType(Long customerId, Integer type);

    /**
     * 保存
     * @param customerMarketing
     */
    void save(CustomerMarketing customerMarketing);
}
