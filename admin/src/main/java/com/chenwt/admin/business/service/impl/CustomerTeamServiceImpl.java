package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.entity.CustomerTeam;
import com.chenwt.admin.business.domain.projection.TeamProjection;
import com.chenwt.admin.business.repository.CustomerTeamRepository;
import com.chenwt.admin.business.service.CustomerTeamService;
import com.chenwt.common.data.PageSort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class CustomerTeamServiceImpl implements CustomerTeamService {
    @Resource
    private CustomerTeamRepository customerTeamRepository;

    @Override
    public void save(CustomerTeam customerTeam) {
        customerTeamRepository.save(customerTeam);
    }

    @Override
    public Page<TeamProjection> getTeamPageList(Long customerId, String teamName) {
        // 创建分页对象
        Pageable page = PageSort.nativePageRequest(Sort.Direction.ASC);
        return customerTeamRepository.getTeamPageList(customerId,teamName,page);
    }

    @Override
    public CustomerTeam findByCustomerId(Long customerId) {
        return customerTeamRepository.findByCustomerId(customerId);
    }
}
