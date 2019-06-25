package com.chenwt.admin.business.service;

import com.chenwt.admin.business.domain.entity.RewardRule;
import com.chenwt.admin.business.domain.projection.RewardRuleProjection;
import com.chenwt.common.enums.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface RewardRuleService {

    /**
     * 获取分页列表数据
     * @param status
     * @param rewardRuleName
     * @return
     */
    Page<RewardRuleProjection> getPageList(Byte status, String rewardRuleName);

    /**
     * 保存
     * @param rewardRule
     */
    void save(RewardRule rewardRule);

    /**
     * 查看详情
     * @param rewardRuleId
     * @return
     */
    RewardRuleProjection findByRewardRuleId(Long rewardRuleId);

    /**
     * 变更状态
     * @param statusEnum
     * @param ids
     * @return
     */
    @Transactional
    Boolean updateStatus(StatusEnum statusEnum, List<Long> ids);
}
