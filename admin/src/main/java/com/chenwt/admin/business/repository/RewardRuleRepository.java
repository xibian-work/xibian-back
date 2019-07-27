package com.chenwt.admin.business.repository;

import com.chenwt.admin.business.domain.entity.RewardRule;
import com.chenwt.admin.business.domain.projection.RewardRuleProjection;
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
public interface RewardRuleRepository extends BaseRepository<RewardRule, Long>, JpaSpecificationExecutor<RewardRule> {
    /**
     * 分页查询
     * @param status
     * @param rewardRuleName
     * @param page
     * @return
     */
    @Query(value = "SELECT r.id, " +
            "r.code, " +
            "r.name, " +
            "c.name as courseName, " +
            "r.money, " +
            "r.percentage, " +
            "r.level, " +
            "r.create_date AS createDate, " +
            "r.status, " +
            "r.remark FROM reward_rule r " +
            "LEFT JOIN course c " +
            "ON r.course_id = c.id " +
            "where r.status != 3 " +
            "and if(:status is NULL,1=1,r.status = :status) " +
            "and if(:rewardRuleName is NULL,1=1,r.name LIKE CONCAT('%', :rewardRuleName,'%')) "
            ,countQuery = "SELECT COUNT(1) FROM reward_rule r " +
            "LEFT JOIN course c " +
            "ON r.course_id = c.id " +
            "where r.status != 3 " +
            "and if(:status is NULL,1=1,r.status = :status) " +
            "and if(:rewardRuleName is NULL,1=1,r.name LIKE CONCAT('%', :rewardRuleName,'%')) "
            ,nativeQuery = true)
    Page<RewardRuleProjection> getPageList(@Param("status") Byte status, @Param("rewardRuleName") String rewardRuleName, Pageable page);

    /**
     * 查看详情
     * @param rewardRuleId
     * @return
     */
    @Query(value = "SELECT r.id, " +
            "r.code, " +
            "r.name, " +
            "c.name as courseName, " +
            "r.money, " +
            "r.percentage, " +
            "r.level, " +
            "u.username AS createName, " +
            "r.create_date AS createDate, " +
            "r.STATUS, " +
            "r.remark FROM reward_rule r " +
            "LEFT JOIN course c " +
            "ON r.course_id = c.id " +
            "LEFT JOIN sys_user u ON u.id = r.create_by " +
            "where r.id = :rewardRuleId",nativeQuery = true)
    RewardRuleProjection findByRewardRuleId(@Param("rewardRuleId") Long rewardRuleId);

    /**
     * 查找
     * @param code
     * @return
     */
    List<RewardRule> findByCode(String code);

    /**
     * 查找
     * @param code
     * @param level
     * @return
     */
    RewardRule findByCodeAndLevel(String code, Byte level);
}
