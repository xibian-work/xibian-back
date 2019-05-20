package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.entity.Customer;
import com.chenwt.admin.business.domain.entity.CustomerMarketing;
import com.chenwt.admin.business.domain.entity.CustomerTeam;
import com.chenwt.admin.business.domain.projection.CustomerProjection;
import com.chenwt.admin.business.domain.vo.RignVO;
import com.chenwt.admin.business.enums.ConstantEnums;
import com.chenwt.admin.business.repository.CustomerRepository;
import com.chenwt.admin.business.service.CustomerMarketingService;
import com.chenwt.admin.business.service.CustomerService;
import com.chenwt.admin.business.service.CustomerTeamService;
import com.chenwt.admin.business.service.StudentService;
import com.chenwt.common.data.PageSort;
import com.chenwt.common.enums.StatusEnum;
import com.chenwt.common.utils.ResultVoUtil;
import com.chenwt.common.vo.ResultVo;
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

    @Override
    public Page<CustomerProjection> getPageList(Byte status, String customerName){
        // 创建分页对象
        Pageable page = PageSort.nativePageRequest(Sort.Direction.ASC);
        return customerRepository.getPageList(status, customerName,page);
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
    public ResultVo sign(RignVO rignVO) {
        ResultVo resultVo = ResultVoUtil.success("领课成功");

        Customer customer = findByPhone(rignVO.getPhone());
        if (null == customer){
            customer = new Customer();
            customer.setPhone(rignVO.getPhone());
            customer.setCreateDate(new Date());
            save(customer);

            //该手机号为新用户，海报推广用户
            if (null != rignVO.getCustomerId()){
                /**
                 * 建立团队关系
                 */
                Customer leaderCustomer = customerRepository.findById(rignVO.getCustomerId()).orElse(null);
                if (null != leaderCustomer){
                    CustomerTeam customerTeam = new CustomerTeam();
                    customerTeam.setLeaderId(leaderCustomer.getId());
                    customerTeam.setCustomerId(customer.getId());
                    customerTeam.setCreateDate(new Date());
                    customerTeamService.save(customerTeam);
                }
            }
            //保存学生信息
            studentService.saveStudent(rignVO.getStudentName(), customer.getId());
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

}
