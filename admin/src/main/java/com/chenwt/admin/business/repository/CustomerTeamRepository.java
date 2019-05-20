package com.chenwt.admin.business.repository;

import com.chenwt.admin.business.domain.entity.CustomerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CustomerTeamRepository extends JpaRepository<CustomerTeam, Long>, JpaSpecificationExecutor<CustomerTeam> {

}
