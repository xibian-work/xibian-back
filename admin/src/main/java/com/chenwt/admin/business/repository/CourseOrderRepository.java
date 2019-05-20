package com.chenwt.admin.business.repository;

import com.chenwt.admin.business.domain.entity.CourseOrder;
import com.chenwt.admin.business.domain.projection.CourseOrderProjection;
import com.chenwt.admin.business.domain.projection.CourseProjection;
import com.chenwt.modules.system.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface CourseOrderRepository extends BaseRepository<CourseOrder, Long>, JpaSpecificationExecutor<CourseOrder> {
    /**
     * 分页查询
     *
     * @param status
     * @param customerName
     * @param page
     * @return
     */
    @Query(value = "SELECT " +
            "t1.id, " +
            "t1.create_date AS createDate, " +
            "t1.status, " +
            "t1.remark, " +
            "t2.NAME AS courseName, " +
            "t3.username AS customerName, " +
            "t4.username AS updateName  " +
            "FROM " +
            "course_order t1 " +
            "LEFT JOIN course t2 ON t2.id = t1.course_id " +
            "LEFT JOIN customer t3 ON t3.id = t1.customer_id " +
            "LEFT JOIN sys_user t4 ON t4.id = t1.update_by " +
            "where 1=1 " +
            "and if(:status is NULL,1=1,t1.status = :status) " +
            "and if(:customerName is NULL,1=1,t3.username LIKE CONCAT('%', :customerName,'%')) "
            , nativeQuery = true)
    Page<CourseOrderProjection> getPageList(@Param("status") Byte status, @Param("customerName") String customerName, Pageable page);

    /**
     * 根据courseOrderId查询
     * @param courseOrderId
     * @return
     */
    @Query(value = "SELECT " +
            "t1.id, " +
            "t1.create_date AS createDate, " +
            "t1.status, " +
            "t1.remark, " +
            "t2.NAME AS courseName, " +
            "t3.username AS customerName, " +
            "t4.username AS updateName  " +
            "FROM " +
            "course_order t1 " +
            "LEFT JOIN course t2 ON t2.id = t1.course_id " +
            "LEFT JOIN customer t3 ON t3.id = t1.customer_id " +
            "LEFT JOIN sys_user t4 ON t4.id = t1.update_by " +
            "where t1.id = :courseOrderId "
            , nativeQuery = true)
    CourseOrderProjection findByCourseOrderId(@Param("courseOrderId") Long courseOrderId);
}
