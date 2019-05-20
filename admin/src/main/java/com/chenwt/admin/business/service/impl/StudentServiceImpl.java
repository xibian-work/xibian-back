package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.entity.Student;
import com.chenwt.admin.business.repository.StudentRepository;
import com.chenwt.admin.business.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @class：OrderServiceImpl
 * @campany：zkzj
 * @author:feiniaoying
 * @date:2019-05-06 01:21
 * @description:
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentRepository studentRepository;


    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void saveStudent(String studentName, Long parentId) {
        Student student = new Student();
        student.setName(studentName);
        student.setParentId(parentId);
        student.setCreateDate(new Date());
        save(student);
    }
}
