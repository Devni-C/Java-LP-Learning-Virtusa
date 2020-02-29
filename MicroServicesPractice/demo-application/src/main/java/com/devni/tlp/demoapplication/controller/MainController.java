package com.devni.tlp.demoapplication.controller;

import com.devni.tlp.demoapplication.model.Student;
import com.devni.tlp.demoapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greetingGet () {
        return "Hello SpringBoot with GET";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String greetingPost() {
        return "Hello SpringBoot with POST";
    }

    @RequestMapping (value = "/student", method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }
}
