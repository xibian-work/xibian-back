package com.chenwt.admin.business.controller;

import com.chenwt.admin.business.domain.projection.CourseProjection;
import com.chenwt.admin.business.domain.vo.CourseVO;
import com.chenwt.admin.business.service.CourseService;
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
@RequestMapping("/business/course")
public class CourseController {
    @Resource
    private CourseService courseService;

    /**
     * 列表页面
     */
    @GetMapping("/index")
    @RequiresPermissions("business:course:index")
    public String index(Model model, CourseVO courseVO) {
        // 获取订单列表
        Page<CourseProjection> list = courseService.getPageList(courseVO.getStatus(),courseVO.getName());

        // 封装数据
        model.addAttribute("list", list.getContent());
        model.addAttribute("page", list);
        return "/business/course/index";
    }

    /**
     * 跳转到详细页面
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("business:course:detail")
    public String toDetail(@PathVariable("id") Long courseId, Model model){
        CourseProjection courseProjection = courseService.findByCourseId(courseId);
        model.addAttribute("course", courseProjection);
        return "/business/course/detail";
    }

}
