package com.chenwt.admin.business.repository;

import com.chenwt.admin.business.domain.entity.CustomerAccount;
import com.chenwt.modules.system.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CustomerAccountRepository extends BaseRepository<CustomerAccount, Long>, JpaSpecificationExecutor<CustomerAccount> {
    /**
     * 查找
     * @param customerId
     * @return
     */
    CustomerAccount findByCustomerId(Long customerId);
}
