package com.chenwt.admin.business.domain.projection;

import java.util.Date;

/**
 * @interface：CustomerProjection
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-06 17:05
 * @description:
 */

public interface CustomerProjection {
    Long getId();

    String getUsername();

    String getPassword();

    String getSalt();

    String getPicture();

    String getSex();

    String getPhone();

    String getEmail();

    Date getCreateDate();

    Date getUpdateDate();

    String getRemark();

    Byte getStatus();

    Integer getTeamCount();
    Double getMoney();
}
