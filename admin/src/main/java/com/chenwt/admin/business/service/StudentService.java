package com.chenwt.admin.business.service;

import com.chenwt.admin.business.domain.entity.Student;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface StudentService {
    /**
     * 保存
     * @param student
     */
    void save(Student student);

    /**
     * 保存
     * @param studentName
     * @param parentId
     */
    void saveStudent(String studentName, Long parentId);
}
