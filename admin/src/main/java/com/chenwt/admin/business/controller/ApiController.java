package com.chenwt.admin.business.controller;

import com.chenwt.admin.business.domain.vo.SignVO;
import com.chenwt.admin.business.service.CustomerService;
import com.chenwt.common.vo.ResultVo;
import com.chenwt.component.actionLog.annotation.EntityParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @class：ApiController
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-17 12:02
 * @description:
 */
@Controller
@RequestMapping("/business/api")
@CrossOrigin(origins = "*")
public class ApiController {
    @Resource
    private CustomerService customerService;

    /**
     * 客户领课
     */
    @RequestMapping("/customer/sign")
    @ResponseBody
    public ResultVo sign(@EntityParam SignVO signVO) {
        // 更新状态
//        return ResultVoUtil.success("领课成功！");
        ResultVo resultVo = customerService.sign(signVO);
        return resultVo;
    }

}
