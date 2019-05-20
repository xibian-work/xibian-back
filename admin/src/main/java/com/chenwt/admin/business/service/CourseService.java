package com.chenwt.admin.business.service;

import com.chenwt.admin.business.domain.projection.CourseProjection;
import org.springframework.data.domain.Page;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CourseService {

    /**
     * 获取分页列表数据
     * @param status
     * @param username
     * @return
     */
    Page<CourseProjection> getPageList(Byte status, String username);

    /**
     * 根据id获取
     * @param courseId
     * @return
     */
    CourseProjection findByCourseId(Long courseId);
}
