package com.chenwt.admin.business.repository;

import com.chenwt.admin.business.domain.entity.Course;
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
public interface CourseRepository extends BaseRepository<Course, Long>, JpaSpecificationExecutor<Course> {
    /**
     * 分页查询
     *
     * @param status
     * @param name
     * @param page
     * @return
     */
    @Query(value = "SELECT t1.id,t1.name, " +
            "t1.price, " +
            "t1.status, " +
            "t2.username as createName, " +
            "t1.create_date as createDate, " +
            "t3.username as updateName, " +
            "t1.update_date as updateDate, " +
            "t2.remark " +
            "from " +
            "course t1 " +
            "LEFT JOIN sys_user t2 " +
            "ON t1.create_by = t2.id " +
            "LEFT JOIN sys_user t3 " +
            "ON t1.update_by = t3.id " +
            "where 1=1 " +
            "and if(:status is NULL,1=1,t1.status = :status) " +
            "and if(:name is NULL,1=1,t1.name LIKE CONCAT('%', :name,'%')) "
            , countQuery = "SELECT COUNT(1)" +
            "from " +
            "course t1 " +
            "where 1=1 " +
            "and if(:status is NULL,1=1,t1.status = :status) " +
            "and if(:name is NULL,1=1,t1.name LIKE CONCAT('%', :name,'%')) "
            , nativeQuery = true)
    Page<CourseProjection> getPageList(@Param("status") Byte status, @Param("name") String name, Pageable page);

    /**
     * 根据courseId获取
     * @param courseId
     * @return
     */
    @Query(value = "SELECT t1.id,t1.name, " +
            "t1.price, " +
            "t1.status, " +
            "t2.username as createName, " +
            "t1.create_date as createDate, " +
            "t3.username as updateName, " +
            "t1.update_date as updateDate, " +
            "t2.remark " +
            "from " +
            "course t1 " +
            "LEFT JOIN sys_user t2 " +
            "ON t1.create_by = t2.id " +
            "LEFT JOIN sys_user t3 " +
            "ON t1.update_by = t3.id " +
            "where t1.id = :courseId "
            , nativeQuery = true)
    CourseProjection findByCourseId(@Param("courseId") Long courseId);
}
