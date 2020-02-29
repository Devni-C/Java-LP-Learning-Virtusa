package com.devni.tlp.demoapplication.service;

import com.devni.tlp.demoapplication.model.Student;
import com.devni.tlp.demoapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student fetchStudentById(int id) {
        //Optional is used to avoid NullPointerException. So you don't need to check whether the result is null or not
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            Student student1 = student.get();
            return student1;
        }
        return null;
    }
}
