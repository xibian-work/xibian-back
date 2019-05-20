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
@Table(name="customer")
@Getter
@Setter
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String salt;
    private String picture;
    private Integer sex;
    private String phone;
    private String email;
    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date updateDate;
    private String remark;
    private Byte status;
}
