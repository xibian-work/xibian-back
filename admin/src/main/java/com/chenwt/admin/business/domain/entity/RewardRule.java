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
@Table(name = "reward_rule")
@Getter
@Setter
public class RewardRule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String code;
    private String name;
    private Long courseId;
    private Double money;
    private Double percentage;
    private Byte level;
    private Long updateBy;
    private Long createBy;
    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date updateDate;
    private Byte status;

    private String remark;
}
