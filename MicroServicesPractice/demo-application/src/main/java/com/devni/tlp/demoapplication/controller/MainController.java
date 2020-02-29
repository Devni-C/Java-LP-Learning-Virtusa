package com.devni.tlp.demoapplication.controller;

import com.devni.tlp.demoapplication.model.Student;
import com.devni.tlp.demoapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greetingGet () {
        return "Hello SpringBoot with  GET";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String greetingPost() {
        return "Hello SpringBoot with POST";
    }

    @RequestMapping (value = "/student", method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

//    @RequestMapping (value = "/studentbyid/{id}", method = RequestMethod.GET)
    @RequestMapping (value = "/student", method = RequestMethod.GET)
    public ResponseEntity<Student> fetchStudentById(@RequestParam int id) {
        Student student = studentService.fetchStudentById(id);
        if(student == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(student);
        }
    }
}
