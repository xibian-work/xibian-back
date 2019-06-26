package com.chenwt.admin.business.service;

import com.chenwt.admin.business.domain.entity.CustomerTeam;
import com.chenwt.admin.business.domain.projection.TeamProjection;
import org.springframework.data.domain.Page;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CustomerTeamService {
    /**
     * 保存
     * @param customerTeam
     */
    void save(CustomerTeam customerTeam);

    /**
     * 查询customerId下团队
     * @param customerId
     * @param teamName
     * @return
     */
    Page<TeamProjection> getTeamPageList(Long customerId, String teamName);

    /**
     * 查找
     * @param customerId
     * @return
     */
    CustomerTeam findByCustomerId(Long customerId);
}
