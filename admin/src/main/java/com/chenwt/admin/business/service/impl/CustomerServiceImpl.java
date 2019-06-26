package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.constants.Constants;
import com.chenwt.admin.business.domain.entity.*;
import com.chenwt.admin.business.domain.projection.CustomerProjection;
import com.chenwt.admin.business.domain.projection.TeamProjection;
import com.chenwt.admin.business.domain.vo.SignVO;
import com.chenwt.admin.business.enums.ConstantEnums;
import com.chenwt.admin.business.repository.CustomerRepository;
import com.chenwt.admin.business.service.*;
import com.chenwt.common.constant.StatusConst;
import com.chenwt.common.data.PageSort;
import com.chenwt.common.enums.StatusEnum;
import com.chenwt.common.utils.ResultVoUtil;
import com.chenwt.common.vo.ResultVo;
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
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private StudentService studentService;

    @Resource
    private CustomerTeamService customerTeamService;

    @Resource
    private CustomerMarketingService customerMarketingService;

    @Resource
    private CustomerAccountService customerAccountService;

    @Resource
    private RewardRuleService rewardRuleService;

    @Override
    public Page<CustomerProjection> getPageList(Byte status, String username){
        // 创建分页对象
        Pageable page = PageSort.nativePageRequest(Sort.Direction.ASC);
        return customerRepository.getPageList(status, username,page);
    }

    @Override
    public CustomerProjection findByCustomerId(Long customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> save(List<Customer> customerList) {
        return customerRepository.saveAll(customerList);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Boolean repeatByUsername(Customer customer) {
        Long id = customer.getId() != null ? customer.getId() : Long.MIN_VALUE;
        return customerRepository.findByUsernameAndIdNot(customer.getUsername(), id) != null;
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean updateStatus(StatusEnum statusEnum, List<Long> ids) {
        return customerRepository.updateStatus(statusEnum.getCode(), ids) > 0;
    }

    @Override
    public Customer findByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public ResultVo sign(SignVO signVO) {
        ResultVo resultVo = ResultVoUtil.success("领课成功");

        Customer customer = findByPhone(signVO.getPhone());
        if (null == customer){
            customer = new Customer();
            customer.setPhone(signVO.getPhone());
            customer.setCreateDate(new Date());
            customer.setStatus(StatusConst.OK);
            save(customer);

            //该手机号为新用户，海报推广用户
            if (null != signVO.getCustomerId()){
                /**
                 * 建立团队关系
                 */
                Customer leaderCustomer = customerRepository.findById(signVO.getCustomerId()).orElse(null);
                if (null != leaderCustomer){
                    CustomerTeam customerTeam = new CustomerTeam();
                    customerTeam.setLeaderId(leaderCustomer.getId());
                    customerTeam.setCustomerId(customer.getId());
                    customerTeam.setCreateDate(new Date());
                    customerTeamService.save(customerTeam);
                }
            }
            //保存学生信息
            studentService.saveStudent(signVO.getStudentName(), customer.getId());
        }

        CustomerMarketing customerMarketing = customerMarketingService.findByCustomerIdAndType(customer.getId(), ConstantEnums.CUSTOMER_MARKETING_1.getKey());
        if (null == customerMarketing){
            customerMarketing = new CustomerMarketing();
            customerMarketing.setCustomerId(customer.getId());
            customerMarketing.setType(ConstantEnums.CUSTOMER_MARKETING_1.getKey());
            customerMarketing.setCreateDate(new Date());

            customerMarketingService.save(customerMarketing);
        }else{
            resultVo.setMsg("该号码重复领取！");
        }

        return resultVo;
    }

    @Override
    public void payMoney(Long customerId, Double money) {
        User user = ShiroUtil.getSubject();
        //先给该用户充值
        customerAccountService.payMoneyToAccount(user.getId(), customerId, money);

        //查找其推荐人
        CustomerTeam customerTeam = customerTeamService.findByCustomerId(customerId);

        //如果有推荐人，则按照奖励规则给予奖励
        if (null != customerTeam){
            //计算奖励金额
            RewardRule rewardRule = rewardRuleService.findByCode(Constants.RewardRule.TEAM_REWARD);
            if (null != rewardRule){
                if (null != rewardRule.getMoney()){
                    money = rewardRule.getMoney();
                }else{
                    if (null != rewardRule.getPercentage()){
                        money = money * rewardRule.getPercentage() / 100;
                    }else {
                        money = 0d;
                    }
                }
                if (0 < money){
                    customerAccountService.payMoneyToAccount(user.getId(), customerTeam.getLeaderId(), money);
                }
            }
        }
        //插入一条充值订单(待用)
    }


    @Override
    public Page<TeamProjection> getTeamPageList(Long customerId, String teamName) {
        return customerTeamService.getTeamPageList(customerId,teamName);
    }

}
