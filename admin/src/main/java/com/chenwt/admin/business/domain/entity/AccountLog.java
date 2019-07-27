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
@Table(name = "account_log")
@Getter
@Setter
public class AccountLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Long customerId;
    protected Long rewardRuleId;
    protected Long accountLogId;

    private Double money;
    @CreatedDate
    private Date createDate;
    private String remark;
}

