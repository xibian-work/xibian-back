package com.chenwt.admin.business.service;

import com.chenwt.admin.business.domain.projection.CourseOrderProjection;
import com.chenwt.admin.business.domain.projection.CourseProjection;
import org.springframework.data.domain.Page;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CourseOrderService {

    /**
     * 获取分页列表数据
     * @param status
     * @param customerName
     * @return
     */
    Page<CourseOrderProjection> getPageList(Byte status, String customerName);

    /**
     * 根据courseOrderId查询
     * @param courseOrderId
     * @return
     */
    CourseOrderProjection findByCourseOrderId(Long courseOrderId);
}
