package com.example.studentcrud.studentcrud.controller;

import com.example.studentcrud.studentcrud.model.Student;
import com.example.studentcrud.studentcrud.repository.StudentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentManagementController {
    @Autowired
    private StudentDaoImpl studentDao;

    @GetMapping("/init")
    public String init(){
        return"Project is running";
    }
    @GetMapping("/master")
    public List<Student> masterData(){
        return studentDao.findAll();
    }
    @GetMapping("/student/{id}")
    public Student findById(@PathVariable int id){
        return studentDao.findById(id);
    }
    @PostMapping("/add")
    public String insert(@RequestBody Student student){
        return studentDao.save(student)+"Student Added Successfully";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return studentDao.deleteById(id)+"Row deleted Successfully";
    }
    @PutMapping("/update/{id}")
    public String update (@RequestBody Student student,@PathVariable int id){
        return studentDao.update(student , id)+"Row updated successfully";
    }
    }

