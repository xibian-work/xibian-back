package com.chenwt.admin.business.enums;

/**
 * @class：ConstantEnums
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-10 18:04
 * @description:
 */
public enum  ConstantEnums {
    PIC_TEMPLATE_DEFAULT_0(0, "非默认"),
    PIC_TEMPLATE_DEFAULT_1(1, "默认"),

    STATUS_1(1, "正常"),
    STATUS_2(2, "冻结"),
    STATUS_3(3, "删除"),


    /**
     * 客户营销类型
     */
    CUSTOMER_MARKETING_1(1,"我要领课")

    ;

    private Integer key;

    private String value;

    ConstantEnums(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }}
