package com.chenwt.admin.business.controller;

import com.chenwt.admin.business.domain.entity.Customer;
import com.chenwt.admin.business.domain.entity.PicTemplate;
import com.chenwt.admin.business.domain.projection.CustomerProjection;
import com.chenwt.admin.business.domain.vo.CustomerVO;
import com.chenwt.admin.business.domain.vo.PicTemplateVO;
import com.chenwt.admin.business.service.CustomerService;
import com.chenwt.admin.business.service.PicTemplateService;
import com.chenwt.admin.business.validator.CustomerValid;
import com.chenwt.common.constant.StatusConst;
import com.chenwt.common.enums.ResultEnum;
import com.chenwt.common.enums.StatusEnum;
import com.chenwt.common.exception.ResultException;
import com.chenwt.common.utils.*;
import com.chenwt.common.vo.ResultVo;
import com.chenwt.component.actionLog.annotation.EntityParam;
import com.chenwt.component.excel.ExcelUtil;
import com.chenwt.component.fileUpload.FileUpload;
import com.chenwt.component.shiro.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author chenwt
 * @date 2018/8/14
 */
@Controller
@RequestMapping("/business/customer")
public class CustomerController implements Serializable {
    @Resource
    private CustomerService customerService;

    @Resource
    private PicTemplateService picTemplateService;

    /**
     * 列表页面
     */
    @GetMapping("/index")
    @RequiresPermissions("business:customer:index")
    public String index(Model model, CustomerVO customerVO) {
        // 获取订单列表
        Page<CustomerProjection> list = customerService.getPageList(customerVO.getStatus(),customerVO.getCustomerName());

        // 封装数据
        model.addAttribute("list", list.getContent());
        model.addAttribute("page", list);
        return "/business/customer/index";
    }

    /**
     * 跳转到详细页面
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("business:customer:detail")
    public String toDetail(@PathVariable("id") Long customerId, Model model){
        CustomerProjection customerProjection = customerService.findByCustomerId(customerId);
        model.addAttribute("customer", customerProjection);
        return "/business/customer/detail";
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
     * 跳转到修改密码页面
     */
    @GetMapping("/pwd")
    @RequiresPermissions("business:customer:pwd")
    public String toEditPassword(Model model, @RequestParam(value = "ids", required = false) List<Long> ids) {
        model.addAttribute("idList", ids);
        return "/business/customer/pwd";
    }

    /**
     * 修改密码
     */
    @PostMapping("/pwd")
    @RequiresPermissions("business:customer:pwd")
    @ResponseBody
    public ResultVo editPassword(String password, String confirm,@RequestParam(value = "ids", required = false) List<Customer> customerList) {
        // 判断密码是否为空
        if (password.isEmpty() || "".equals(password.trim())) {
            throw new ResultException(ResultEnum.USER_PWD_NULL);
        }

        // 判断两次密码是否一致
        if (!password.equals(confirm)) {
            throw new ResultException(ResultEnum.USER_INEQUALITY);
        }

        // 修改密码，对密码进行加密
        customerList.forEach(customer -> {
            String salt = ShiroUtil.getRandomSalt();
            String encrypt = ShiroUtil.encrypt(password, salt);
            customer.setPassword(encrypt);
            customer.setSalt(salt);
            customer.setUpdateDate(new Date());
        });

        // 保存数据
        customerService.save(customerList);
        return ResultVoUtil.success("修改成功");
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping("/add")
    @RequiresPermissions("business:customer:add")
    public String toAdd() {
        return "/business/customer/add";
    }
    /**
     * 跳转到编辑页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("business:customer:edit")
    public String toEdit(@PathVariable("id") Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return "/business/customer/add";
    }

    /**
     * 保存添加/修改的数据
     * @param valid 验证对象
     * @param customer 实体对象
     */
    @PostMapping("/save")
    @RequiresPermissions({"business:customer:add", "business:customer:edit"})
    @ResponseBody
    public ResultVo save(@Validated CustomerValid valid, @EntityParam Customer customer) {

        // 验证数据是否合格
        if (customer.getId() == null) {

            // 判断密码是否为空
            if (customer.getPassword().isEmpty() || "".equals(customer.getPassword().trim())) {
                throw new ResultException(ResultEnum.USER_PWD_NULL);
            }

            // 判断两次密码是否一致
            if (!customer.getPassword().equals(valid.getConfirm())) {
                throw new ResultException(ResultEnum.USER_INEQUALITY);
            }

            customer.setStatus(StatusConst.OK);
            customer.setCreateDate(new Date());

            // 对密码进行加密
            String salt = ShiroUtil.getRandomSalt();
            String encrypt = ShiroUtil.encrypt(customer.getPassword(), salt);
            customer.setPassword(encrypt);
            customer.setSalt(salt);
        }

        // 判断用户名是否重复
        if (customerService.repeatByUsername(customer)) {
            throw new ResultException(ResultEnum.USER_EXIST);
        }

        // 复制保留无需修改的数据
        if (customer.getId() != null) {
            Customer beCustomer = customerService.getById(customer.getId());
            String[] fields = {"password", "salt", "picture"};
            EntityBeanUtil.copyProperties(beCustomer, customer, fields);
            customer.setUpdateDate(new Date());
        }

        // 保存数据
        customerService.save(customer);
        return ResultVoUtil.SAVE_SUCCESS;
    }

    /**
     * 设置一条或者多条数据的状态
     */
    @RequestMapping("/status/{param}")
    @RequiresPermissions("business:customer:status")
    @ResponseBody
    public ResultVo updateStatus(
            @PathVariable("param") String param,
            @RequestParam(value = "ids", required = false) List<Long> ids) {

        // 更新状态
        StatusEnum statusEnum = StatusUtil.getStatusEnum(param);
        if (customerService.updateStatus(statusEnum, ids)) {
            return ResultVoUtil.success(statusEnum.getMessage() + "成功");
        } else {
            return ResultVoUtil.error(statusEnum.getMessage() + "失败，请重新操作");
        }
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping("/toPoster")
    @RequiresPermissions("business:customer:toPoster")
    public String toPoster(Model model, @RequestParam(value = "ids") Long customerId,PicTemplateVO picTemplateVO) {
        // 获取用户列表
        Page<PicTemplate> list = picTemplateService.getPageList(picTemplateVO.getTitle());

        // 封装数据
        model.addAttribute("customerId", customerId);
        model.addAttribute("list", list.getContent());
        model.addAttribute("page", list);
        return "/business/customer/poster";
    }


    /**
     * 合成推广海报
     */
    @RequestMapping("/createPoster")
    @RequiresPermissions("business:customer:toPoster")
    @ResponseBody
    public ResultVo updateStatus(@RequestParam("customerId") Long customerId, @RequestParam("picture") String picture, HttpServletResponse resp) {
        try {
            //生成二维码
            BufferedImage code = QRCodeUtil.createImage("https://gitee.com/chenwt?customerId="+customerId, null, false);
            //合成二维码和图片为输出流，直接展示
            picture = FileUpload.getFilePath(picture);
            String picBase64 = QRCodeUtil.combineCodeAndPicToBase64(picture,code);
            ResultVo resultVo = ResultVoUtil.success();
            resultVo.setData(picBase64);
            return resultVo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResultException(ResultEnum.SERVER_ERROR);
        }
    }

}
