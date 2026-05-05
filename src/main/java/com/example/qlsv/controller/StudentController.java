package com.example.qlsv.controller;

import com.example.qlsv.entity.Student;
import com.example.qlsv.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service=service;
    }

    // YÊU CẦU 5 - GET ALL
    @GetMapping
    public List<Student> getAll(){
        return service.getAll();
    }

    // YÊU CẦU 4 - GET BY ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable String id){
        return service.getById(id);
    }

    // YÊU CẦU 1 - ADD
    @PostMapping
    public Student add(@RequestBody Student s){
        return service.add(s);
    }

    // YÊU CẦU 6 - UPDATE
    @PostMapping("/update/{id}")
    public Student update(@PathVariable String id,@RequestBody Student s){
        return service.update(id,s);
    }

    // YÊU CẦU 2 - DELETE
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    // YÊU CẦU 3 - SEARCH
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name){
        return service.search(name);
    }
}