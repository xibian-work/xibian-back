package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.entity.RewardRule;
import com.chenwt.admin.business.domain.projection.RewardRuleProjection;
import com.chenwt.admin.business.repository.RewardRuleRepository;
import com.chenwt.admin.business.service.RewardRuleService;
import com.chenwt.common.data.PageSort;
import com.chenwt.common.enums.StatusEnum;
import com.chenwt.common.utils.EntityBeanUtil;
import com.chenwt.component.shiro.ShiroUtil;
import com.chenwt.modules.system.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @class：OrderServiceImpl
 * @campany：zkzj
 * @author:feiniaoying
 * @date:2019-05-06 01:21
 * @description:
 */
@Service
public class RewardRuleServiceImpl implements RewardRuleService {
    @Resource
    private RewardRuleRepository rewardRuleRepository;

    @Override
    public Page<RewardRuleProjection> getPageList(Byte status, String rewardRuleName){
        // 创建分页对象
        Pageable page = PageSort.nativePageRequest(Sort.Direction.ASC);
        return rewardRuleRepository.getPageList(status, rewardRuleName,page);
    }

    @Override
    public void save(RewardRule rewardRule) {
        User user = ShiroUtil.getSubject();
        // 复制保留无需修改的数据
        if (rewardRule.getId() != null) {
            RewardRule beRewardRule = rewardRuleRepository.findById(rewardRule.getId()).orElse(null);;
            EntityBeanUtil.copyProperties(beRewardRule, rewardRule);

            rewardRule.setUpdateBy(user.getId());
            rewardRule.setUpdateDate(new Date());
        }else{
            rewardRule.setStatus(StatusEnum.OK.getCode());
            rewardRule.setCreateBy(user.getId());
            rewardRule.setCreateDate(new Date());
        }
        rewardRuleRepository.save(rewardRule);
    }

    @Override
    public RewardRuleProjection findByRewardRuleId(Long rewardRuleId) {
        return rewardRuleRepository.findByRewardRuleId(rewardRuleId);
    }


    @Override
    public Boolean updateStatus(StatusEnum statusEnum, List<Long> ids) {
        return rewardRuleRepository.updateStatus(statusEnum.getCode(), ids) > 0;
    }

    @Override
    public List<RewardRule> findByCode(String code) {
        return rewardRuleRepository.findByCode(code);
    }

    @Override
    public RewardRule findByCodeAndLevel(String code, Integer level) {
        return rewardRuleRepository.findByCodeAndLevel(code,level);
    }
}
