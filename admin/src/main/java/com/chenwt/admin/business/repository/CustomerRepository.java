package com.chenwt.admin.business.repository;

import com.chenwt.admin.business.domain.entity.Customer;
import com.chenwt.admin.business.domain.projection.CustomerProjection;
import com.chenwt.modules.system.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CustomerRepository extends BaseRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    /**
     * 分页查询
     * @param status
     * @param username
     * @param page
     * @return
     */
    @Query(value = "SELECT c.id, " +
            "c.username, " +
            "a.money, " +
            "(SELECT COUNT(1) from customer_team WHERE leader_id = c.id) as teamCount, " +
            "c.phone, " +
            "c.email, " +
            "c.sex," +
            "c.remark, " +
            "c.create_date AS createDate, " +
            "c.STATUS  FROM customer c " +
            "LEFT JOIN customer_account a on a.customer_id = c.id " +
            "where c.status != 3 " +
            "and if(:status is NULL,1=1,c.status = :status) " +
            "and if(:username is NULL,1=1,c.username LIKE CONCAT('%', :username,'%')) "
            ,countQuery = "SELECT COUNT(1) FROM customer c " +
            "where c.status != 3 " +
            "and if(:status is NULL,1=1,c.status = :status) " +
            "and if(:username is NULL,1=1,c.username LIKE CONCAT('%', :username,'%')) " +
            "order by c.create_date asc "
            ,nativeQuery = true)
    Page<CustomerProjection> getPageList(@Param("status") Byte status, @Param("username") String username, Pageable page);

    /**
     * 分页查询
     * @param customerId
     * @return
     */
    @Query(value = "SELECT c.id, " +
            "c.username, " +
            "a.money, " +
            "(SELECT COUNT(1) from customer_team t WHERE t.leader_id = c.id) as teamCount, " +
            "c.phone, " +
            "c.email, " +
            "c.sex, " +
            "c.create_date AS createDate, " +
            "c.remark, " +
            "c.STATUS  FROM customer c " +
            "LEFT JOIN customer_account a on a.customer_id = c.id " +
            "where c.id = :customerId "
            ,nativeQuery = true)
    CustomerProjection findByCustomerId(@Param("customerId")Long customerId);

    /**
     * 查找
     * @param username
     * @param id
     * @return
     */
    Boolean findByUsernameAndIdNot(String username, Long id);

    /**
     * 删除
     * @param ids
     * @return
     */
    Integer deleteByIdIn(List<Long> ids);

    /**
     * 根据手机号查询
     * @param phone
     * @return
     */
    Customer findByPhone(String phone);
}
