package com.chenwt.admin.business.domain.projection;

import java.util.Date;

/**
 * @interface：TeamProjection
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-06 17:05
 * @description:
 */

public interface TeamProjection {
    Long getId();

    String getLeadName();

    String getTeamName();
    String getTeamPhone();

    Date getCreateDate();
}
