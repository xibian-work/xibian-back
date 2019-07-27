package com.chenwt.admin.business.repository;

import com.chenwt.admin.business.domain.entity.AccountLog;
import com.chenwt.modules.system.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface AccountLogRepository extends BaseRepository<AccountLog, Long>, JpaSpecificationExecutor<AccountLog> {

}
