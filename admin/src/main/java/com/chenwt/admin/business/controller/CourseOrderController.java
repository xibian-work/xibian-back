package com.chenwt.admin.business.controller;

import com.chenwt.admin.business.domain.projection.CourseOrderProjection;
import com.chenwt.admin.business.domain.projection.CourseProjection;
import com.chenwt.admin.business.domain.vo.CourseOrderVO;
import com.chenwt.admin.business.service.CourseOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @class：OrderController
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-05 21:15
 * @description: 订单管理
 */
@Controller
@RequestMapping("/business/courseOrder")
public class CourseOrderController {
    @Resource
    private CourseOrderService courseOrderService;

    /**
     * 列表页面
     */
    @GetMapping("/index")
    @RequiresPermissions("business:courseOrder:index")
    public String index(Model model, CourseOrderVO orderVO) {
        // 获取订单列表
        Page<CourseOrderProjection> list = courseOrderService.getPageList(orderVO.getStatus(),orderVO.getCustomerName());

        // 封装数据
        model.addAttribute("list", list.getContent());
        model.addAttribute("page", list);
        return "/business/courseOrder/index";
    }

    /**
     * 跳转到详细页面
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("business:courseOrder:detail")
    public String toDetail(@PathVariable("id") Long courseOrderId, Model model){
        CourseOrderProjection courseOrderProjection = courseOrderService.findByCourseOrderId(courseOrderId);
        model.addAttribute("courseOrder", courseOrderProjection);
        return "/business/courseOrder/detail";
    }

}
