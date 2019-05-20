package com.chenwt.admin.business.repository;

import com.chenwt.admin.business.domain.entity.CustomerMarketing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CustomerMarketingRepository extends JpaRepository<CustomerMarketing, Long>, JpaSpecificationExecutor<CustomerMarketing> {
    /**
     * 查询
     * @param customerId
     * @param type
     * @return
     */
    CustomerMarketing findByCustomerIdAndType(Long customerId,Integer type);
}
