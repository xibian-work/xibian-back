package com.chenwt.admin.business.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @class：Children
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-17 14:24
 * @description: 学生实体类
 */
@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String name;
    private Integer sex;
    private Long parentId;
    private String remark;
    private Integer age;
    @CreatedDate
    private Date createDate;

}
