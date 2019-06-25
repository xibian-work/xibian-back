package com.chenwt.admin.business.domain.projection;

import java.util.Date;

/**
 * @interface：CustomerProjection
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-06 17:05
 * @description:
 */

public interface RewardRuleProjection {
    Long getId();

    String getCode();

    String getName();

    String getCourseName();

    String getMoney();

    String getPercentage();

    Byte getLevel();

    String getCreateName();
    Date getCreateDate();

    String getUpdateName();
    Date getUpdateDate();

    Byte getStatus();

    String getRemark();
}