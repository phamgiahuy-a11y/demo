package com.example.qlsv.service;

import com.example.qlsv.entity.Student;
import com.example.qlsv.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo){
        this.repo=repo;
    }

    // GET ALL
    public List<Student> getAll(){
        return repo.findAll();
    }

    // GET BY ID
    public Student getById(String id){
        return repo.findById(id).orElse(null);
    }

    // ADD
    public Student add(Student s){
        s.setId(UUID.randomUUID().toString());
        return repo.save(s);
    }

    // UPDATE
    public Student update(String id,Student s){

        Student old=repo.findById(id).orElse(null);

        if(old!=null){
            old.setName(s.getName());
            old.setAge(s.getAge());
            old.setEmail(s.getEmail());
            old.setGender(s.getGender());
            return repo.save(old);
        }

        return null;
    }

    // DELETE
    public void delete(String id){
        repo.deleteById(id);
    }

    // SEARCH
    public List<Student> search(String name){
        return repo.findByNameContainingIgnoreCase(name);
    }
}