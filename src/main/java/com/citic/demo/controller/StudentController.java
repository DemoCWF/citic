package com.citic.demo.controller;

import com.citic.demo.entity.Student;
import com.citic.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
    @Resource
    private StudentService studentService;

    @ResponseBody
    @GetMapping(value = "/get")
    public Student getStudent(){
        return studentService.getById(1);
    }

}
