package com.chenwt.admin.business.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @class：CustomerMoneyVO
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-06-25 16:36
 * @description:
 */
@Setter
@Getter
@ToString
public class CustomerMoneyVO {
    private Long customerId;
    private Double money;
}
