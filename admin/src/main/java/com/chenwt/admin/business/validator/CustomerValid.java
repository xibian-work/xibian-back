package com.chenwt.admin.business.validator;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * @class：PicTemplateValid
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-14 21:22
 * @description:
 */
@Data
public class CustomerValid implements Serializable {
    @NotEmpty(message = "客户名不能为空")
    @Size(min = 2, message = "用户昵称：请输入至少2个字符")
    private String username;

    private String confirm;
}

