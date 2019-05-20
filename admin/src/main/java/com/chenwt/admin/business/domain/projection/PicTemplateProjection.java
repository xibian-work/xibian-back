package com.chenwt.admin.business.domain.projection;

import java.util.Date;

/**
 * @class：OrderProjection
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-06 12:41
 * @description:
 */
public interface PicTemplateProjection {
    //@Value("#{target.emailColumn}")//当别名与该getXXX名称不一致时，可以使用该注解调整
    Long getId();
    String getNickname();
    String getUsername();
    Date getCreateDate();
    Date getUpdateDate();
    Integer getStatus();
    String getRemark();
    String getStatusValue();
}
