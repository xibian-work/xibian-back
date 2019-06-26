package com.chenwt.admin.business.repository;

import com.chenwt.admin.business.domain.entity.CustomerTeam;
import com.chenwt.admin.business.domain.projection.TeamProjection;
import com.chenwt.modules.system.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CustomerTeamRepository extends JpaRepository<CustomerTeam, Long>, JpaSpecificationExecutor<CustomerTeam> {
    /**
     * 查看customerId下团队
     *
     * @param customerId
     * @param teamName
     * @param page
     * @return
     */
    @Query(value = "SELECT t1.id, " +
            "t2.username as leadName, " +
            "t3.username as teamName, " +
            "t3.phone as teamPhone, " +
            "t1.create_date as createDate " +
            "FROM customer_team t1 " +
            "LEFT JOIN customer t2 on t1.leader_id = t2.id " +
            "LEFT JOIN customer t3 on t1.customer_id = t3.id " +
            "where t2.id = :customerId " +
            "and if(:teamName is NULL,1=1,t3.username LIKE CONCAT('%', :teamName,'%')) "
            ,countQuery = "SELECT COUNT(1)" +
            "FROM customer_team t1 " +
            "LEFT JOIN customer t2 on t1.leader_id = t2.id " +
            "LEFT JOIN customer t3 on t1.customer_id = t3.id " +
            "where t2.id = :customerId " +
            "and if(:teamName is NULL,1=1,t3.username LIKE CONCAT('%', :teamName,'%')) "
            , nativeQuery = true)
    Page<TeamProjection> getTeamPageList(@Param("customerId") Long customerId, @Param("teamName") String teamName, Pageable page);

    /***
     * 查找
     * @param customerId
     * @return
     */
    CustomerTeam findByCustomerId(Long customerId);

}
