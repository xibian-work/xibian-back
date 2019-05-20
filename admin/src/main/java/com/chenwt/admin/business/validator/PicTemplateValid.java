package com.chenwt.admin.business.validator;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @class：PicTemplateValid
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-14 21:22
 * @description:
 */
@Data
public class PicTemplateValid implements Serializable {
    @NotEmpty(message = "图片不能为空")
    private String picture;
    @NotEmpty(message = "名称不能为空")
    private String title;
    @Email
    private String email;
}
