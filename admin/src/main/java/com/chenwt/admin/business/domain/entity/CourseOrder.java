package com.chenwt.admin.business.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenwt
 * @date 2018/8/14
 */
@Entity
@Table(name = "course_order")
@Getter
@Setter
public class CourseOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private Long customerId;
    private Long courseId;
    private Byte status;
    private String remark;
    private Long updateBy;
    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date updateDate;
}
