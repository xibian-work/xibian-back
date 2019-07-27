package com.chenwt.admin.business.service;

import com.chenwt.admin.business.domain.entity.AccountLog;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface AccountLogService {

    /**
     * 插入账户日志表
     * @param accountLog
     */
    void saveAccountLog(AccountLog accountLog);
}
