package com.example.studentcrud.studentcrud.repository;

import com.example.studentcrud.studentcrud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class StudentDaoImpl implements IstudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    private final String SELECT_ALL="SELECT * FROM STUDENT";
    private final String SELECT_BY_ID="SELECT * FROM STUDENT WHERE ID = ?";
    private final String DELETE_BY_ID="DELETE FROM STUDENT WHERE ID = ?";
    private final String INSERT="INSERT INTO STUDENT ( firstName,lastName,department) values(?,?,?)";
    private final String UPDATE_BY_ID="UPDATE STUDENT SET firstName=?,lastName=?,department=? where id=?";

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query(SELECT_ALL,new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public Student findById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID,new BeanPropertyRowMapper<Student>(Student.class),id);
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(DELETE_BY_ID,id);
    }

    @Override
    public int save(Student student) {
        return jdbcTemplate.update(INSERT,new Object[]{student.getFirstName(),student.getLastName(),student.getDepartment() });
    }

    @Override
    public int update(Student student,int id) {
        return jdbcTemplate.update(UPDATE_BY_ID, new Object[]{student.getFirstName(),student.getLastName(),student.getDepartment(),id});
    }

}
