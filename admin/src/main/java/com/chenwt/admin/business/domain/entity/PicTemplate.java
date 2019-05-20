package com.chenwt.admin.business.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @class：PicTemplate
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-10 17:41
 * @description: 图片模板
 */
@Entity
@Table(name="pic_template")
@Getter
@Setter
public class PicTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String title;
    private String picture;
    private Integer sort;
    private Integer isDefault;
    private String remark;
    private Long updateBy;
    private Long createBy;
    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date updateDate;
}
