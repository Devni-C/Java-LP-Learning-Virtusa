package com.devni.tlp.demoapplication.repository;

import com.devni.tlp.demoapplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
