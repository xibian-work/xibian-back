package com.chenwt.admin.business.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @class：OrderVO
 * @campany：zkzj
 * @author:feiniaoying
 * @date:2019-05-06 01:11
 * @description: 前台查询条件VO封装
 */
@Setter
@Getter
@ToString
public class PicTemplateVO implements Serializable {
    private String title;
}
