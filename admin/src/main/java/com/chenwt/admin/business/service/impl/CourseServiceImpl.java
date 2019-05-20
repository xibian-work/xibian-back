package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.projection.CourseProjection;
import com.chenwt.admin.business.repository.CourseRepository;
import com.chenwt.admin.business.service.CourseService;
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
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseRepository courseRepository;

    @Override
    public Page<CourseProjection> getPageList(Byte status, String name) {
        // 创建分页对象
        Pageable page = PageSort.nativePageRequest(Sort.Direction.ASC);
        return courseRepository.getPageList(status, name,page);
    }

    @Override
    public CourseProjection findByCourseId(Long courseId) {
        return courseRepository.findByCourseId(courseId);
    }
}
