package com.chenwt;

import com.chenwt.admin.business.constants.Constants;
import com.chenwt.admin.business.domain.entity.CustomerTeam;
import com.chenwt.admin.business.domain.entity.RewardRule;
import com.chenwt.admin.business.service.CustomerTeamService;
import com.chenwt.admin.business.service.RewardRuleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * @class：Test01
 * @campany：zkzj
 * @author:feiniaoying
 * @date:2019-05-04 21:20
 * @description:
 */
public class Test01 extends BaseTest {
    @Value("${project.ke-url}")
    private String keUrl;


    @Resource
    private CustomerTeamService customerTeamService;
    @Resource
    private RewardRuleService rewardRuleService;

    @Test
    public void test01(){
        // 创建分页对象
        //查找其推荐人
        RewardRule rewardRule = rewardRuleService.findByCodeAndLevel(Constants.RewardRule.TEAM_REWARD,Constants.RewardRule.LEVEL_1);
        rewardRule = rewardRuleService.findByCodeAndLevel(Constants.RewardRule.TEAM_REWARD,Constants.RewardRule.LEVEL_2);
        System.out.println(keUrl+"?customerId=");
    }
}
