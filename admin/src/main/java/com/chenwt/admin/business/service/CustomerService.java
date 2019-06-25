package com.chenwt.admin.business.service;

import com.chenwt.admin.business.domain.entity.Customer;
import com.chenwt.admin.business.domain.projection.CustomerProjection;
import com.chenwt.admin.business.domain.projection.RewardRuleProjection;
import com.chenwt.admin.business.domain.projection.TeamProjection;
import com.chenwt.admin.business.domain.vo.SignVO;
import com.chenwt.common.enums.StatusEnum;
import com.chenwt.common.vo.ResultVo;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CustomerService {

    /**
     * 获取分页列表数据
     * @param status
     * @param customerName
     * @return
     */
    Page<CustomerProjection> getPageList(Byte status, String customerName);

    /**
     * 根据customerId获取
     * @param customerId
     * @return
     */
    CustomerProjection findByCustomerId(Long customerId);

    /**
     * 查找全部
     * @return
     */
    List<Customer> findAll();

    /**
     * 修改
     * @param customerList
     * @return
     */
    List<Customer> save(List<Customer> customerList);

    /**
     * 新增
     * @param customer
     * @return
     */
    Customer save(Customer customer);

    /**
     * 查看是否有重复客户名
     * @param customer
     * @return
     */
    Boolean repeatByUsername(Customer customer);

    /**
     * 根据获取
     * @param id
     * @return
     */
    Customer getById(Long id);

    /**
     * 更新状态
     * @param statusEnum
     * @param ids
     * @return
     */
    @Transactional
    Boolean updateStatus(StatusEnum statusEnum, List<Long> ids);

    /**
     * 根据手机号查询
     * @param phone
     * @return
     */
    Customer findByPhone(String phone);

    /**
     * 领课推广
     * @param signVO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    ResultVo sign(SignVO signVO);

    /**
     * 充值
     * @param customerId
     * @param money
     */
    @Transactional(rollbackFor = Exception.class)
    void payMoney(Long customerId, Double money);

    /**
     * 查看customerId下团队
     *
     * @param customerId
     * @param teamName
     * @return
     */
    Page<TeamProjection> getTeamPageList(Long customerId, String teamName);
}
