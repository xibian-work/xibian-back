package com.chenwt.admin.business.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @class：RignVO
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-17 14:17
 * @description: 我要领课
 */
@Setter
@Getter
@ToString
public class SignVO implements Serializable {
    private Long customerId;
    private String phone;
    private String studentName;
}
