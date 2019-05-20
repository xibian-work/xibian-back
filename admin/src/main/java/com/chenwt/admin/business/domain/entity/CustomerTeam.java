package com.chenwt.admin.business.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @class：CustomerTeam
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-17 14:50
 * @description:
 */
@Entity
@Table(name="customer_team")
@Getter
@Setter
public class CustomerTeam {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long leaderId;
    private Long customerId;
    private Integer level;

    @CreatedDate
    private Date createDate;
}
