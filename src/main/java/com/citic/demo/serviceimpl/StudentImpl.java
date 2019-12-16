package com.citic.demo.serviceimpl;

import com.citic.demo.entity.Student;
import com.citic.demo.mapper.StudentMapper;
import com.citic.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title:
 * Description:
 * Create time  2019/12/16
 * Author：Democwf
 */
@Service(value = "userService")
public class StudentImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student getById(Integer id) {
        return this.studentMapper.selectByPrimaryKey(id);
    }
}
