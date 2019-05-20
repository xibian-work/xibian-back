package com.chenwt.admin.business.domain.projection;

import java.util.Date;

/**
 * @class：OrderProjection
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-06 12:41
 * @description:
 */
public interface CourseOrderProjection {
    //@Value("#{target.emailColumn}")//当别名与该getXXX名称不一致时，可以使用该注解调整
    Long getId();
    String getCustomerName();
    String getCourseName();
    Date getCreateDate();
    String getUpdateName();
    Date getUpdateDate();
    Byte getStatus();
    String getRemark();
}
