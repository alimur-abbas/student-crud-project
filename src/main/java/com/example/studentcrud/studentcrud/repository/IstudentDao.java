package com.example.studentcrud.studentcrud.repository;

import com.example.studentcrud.studentcrud.model.Student;

import java.util.List;

public interface IstudentDao {

    public List<Student> findAll();

    public Student findById(int id);

    public int deleteById(int id);

    public int save(Student student);

    public int update(Student student,int id);
}
