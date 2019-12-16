package com.citic.demo.controller;

import com.citic.demo.entity.Student;
import com.citic.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title:
 * Description:
 * Create time  2019/12/16
 * Author：Democwf
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping(value = "/get")
    public Student getStudent(){
        return studentService.getById(1);
    }

}
