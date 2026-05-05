package com.example.qlsv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.qlsv.entity.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByNameContainingIgnoreCase(String name);

}