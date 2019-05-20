package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.projection.CourseOrderProjection;
import com.chenwt.admin.business.domain.projection.CourseProjection;
import com.chenwt.admin.business.repository.CourseOrderRepository;
import com.chenwt.admin.business.service.CourseOrderService;
import com.chenwt.common.data.PageSort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @class：OrderServiceImpl
 * @campany：zkzj
 * @author:feiniaoying
 * @date:2019-05-06 01:21
 * @description:
 */
@Service
public class CourseOrderServiceImpl implements CourseOrderService {
    @Resource
    private CourseOrderRepository courseOrderRepository;

    @Override
    public Page<CourseOrderProjection> getPageList(Byte status, String customerName) {
        // 创建分页对象
        Pageable page = PageSort.nativePageRequest(Sort.Direction.ASC);
        return courseOrderRepository.getPageList(status, customerName, page);
    }

    @Override
    public CourseOrderProjection findByCourseOrderId(Long courseOrderId) {
        return courseOrderRepository.findByCourseOrderId(courseOrderId);
    }
}
