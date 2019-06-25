package com.chenwt.admin.business.validator;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;


/**
 * @class：PicTemplateValid
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-14 21:22
 * @description:
 */
@Data
public class CustomerMoneyValid implements Serializable {
    @NotNull(message = "金额不能为空")
    @DecimalMin(value = "0",message = "充值金额必须大于0")
    private Double money;
}

