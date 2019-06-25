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
public class RewardRuleValid implements Serializable {
    @NotEmpty(message = "奖励编码不能为空")
    @Pattern(regexp = "^\\w+$",message = "奖励编码由字母或下划线组成的字符串组成")
    private String code;
    @NotEmpty(message = "奖励名称不能为空")
    private String name;

    @DecimalMin(value = "0",message = "奖励金额不能小于0")
    private Double money;

    @DecimalMin(value = "0",message = "奖励比例不能小于0")
    @DecimalMax(value = "100",message = "奖励比例不能大于100")
    private Double percentage;
}

