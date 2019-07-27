package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.entity.AccountLog;
import com.chenwt.admin.business.repository.AccountLogRepository;
import com.chenwt.admin.business.service.AccountLogService;
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
public class AccountLogServiceImpl implements AccountLogService {
    @Resource
    private AccountLogRepository accountLogRepository;


    @Override
    public void saveAccountLog(AccountLog accountLog) {
        accountLogRepository.save(accountLog);
    }
}
