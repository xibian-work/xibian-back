package com.chenwt.admin.business.domain.projection;

import java.util.Date;

/**
 * @class：OrderProjection
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-06 12:41
 * @description:
 */
public interface CourseProjection {
    Long getId();
    String getName();
    Double getPrice();
    String getCreateName();
    Date getCreateDate();
    String getUpdateName();
    Date getUpdateDate();
    String getRemark();
    Byte getStatus();
}
