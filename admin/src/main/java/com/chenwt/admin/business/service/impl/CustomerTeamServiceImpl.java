package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.entity.CustomerTeam;
import com.chenwt.admin.business.repository.CustomerTeamRepository;
import com.chenwt.admin.business.service.CustomerTeamService;
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
}
