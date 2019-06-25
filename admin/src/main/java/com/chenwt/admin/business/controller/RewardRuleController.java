package com.chenwt.admin.business.controller;

import com.chenwt.admin.business.domain.entity.Customer;
import com.chenwt.admin.business.domain.entity.RewardRule;
import com.chenwt.admin.business.domain.projection.RewardRuleProjection;
import com.chenwt.admin.business.domain.vo.RewardRuleVO;
import com.chenwt.admin.business.service.CustomerService;
import com.chenwt.admin.business.service.RewardRuleService;
import com.chenwt.admin.business.validator.RewardRuleValid;
import com.chenwt.common.enums.StatusEnum;
import com.chenwt.common.utils.ResultVoUtil;
import com.chenwt.common.utils.StatusUtil;
import com.chenwt.common.vo.ResultVo;
import com.chenwt.component.actionLog.annotation.EntityParam;
import com.chenwt.component.excel.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author chenwt
 * @date 2018/8/14
 */
@Controller
@RequestMapping("/business/rewardRule")
public class RewardRuleController implements Serializable {
    @Resource
    private CustomerService customerService;

    @Resource
    private RewardRuleService rewardRuleService;

    /**
     * 列表页面
     */
    @GetMapping("/index")
    @RequiresPermissions("business:rewardRule:index")
    public String index(Model model, RewardRuleVO rewardRuleVO) {
        // 获取奖励列表
        Page<RewardRuleProjection> list = rewardRuleService.getPageList(rewardRuleVO.getStatus(),rewardRuleVO.getRewardRuleName());

        // 封装数据
        model.addAttribute("list", list.getContent());
        model.addAttribute("page", list);
        return "/business/rewardRule/index";
    }

    /**
     * 跳转到详细页面
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("business:rewardRule:detail")
    public String toDetail(@PathVariable("id") Long rewardRuleId, Model model){
        RewardRuleProjection rewardRuleProjection = rewardRuleService.findByRewardRuleId(rewardRuleId);
        model.addAttribute("rewardRule", rewardRuleProjection);
        return "/business/rewardRule/detail";
    }

    /**
     * 导出用户数据
     */
    @GetMapping("/export")
    @ResponseBody
    public void exportExcel() {
        List<Customer> customerList = customerService.findAll();
        ExcelUtil.exportExcel(Customer.class, customerList);
    }


    /**
     * 跳转到添加页面
     */
    @GetMapping("/add")
    @RequiresPermissions("business:rewardRule:add")
    public String toAdd() {
        return "/business/rewardRule/add";
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("business:rewardRule:edit")
    public String toEdit(@PathVariable("id") RewardRule rewardRule, Model model) {
        model.addAttribute("rewardRule", rewardRule);
        return "/business/rewardRule/add";
    }

    /**
     * 保存添加/修改的数据
     * @param valid 验证对象
     * @param rewardRule 实体对象
     */
    @PostMapping("/save")
    @RequiresPermissions({"business:rewardRule:add", "business:rewardRule:edit"})
    @ResponseBody
    public ResultVo save(@Validated RewardRuleValid valid, @EntityParam RewardRule rewardRule) {
        // 保存数据
        rewardRuleService.save(rewardRule);
        return ResultVoUtil.SAVE_SUCCESS;
    }

    /**
     * 设置一条或者多条数据的状态
     */
    @RequestMapping("/status/{param}")
    @RequiresPermissions("business:rewardRule:status")
    @ResponseBody
    public ResultVo updateStatus(
            @PathVariable("param") String param,
            @RequestParam(value = "ids", required = false) List<Long> ids) {

        // 更新状态
        StatusEnum statusEnum = StatusUtil.getStatusEnum(param);
        if (rewardRuleService.updateStatus(statusEnum, ids)) {
            return ResultVoUtil.success(statusEnum.getMessage() + "成功");
        } else {
            return ResultVoUtil.error(statusEnum.getMessage() + "失败，请重新操作");
        }
    }
}
