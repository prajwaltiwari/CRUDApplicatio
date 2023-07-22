package com.prajwal.cruddemo.dao;

import com.prajwal.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    void save (Student thestudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastNameAsc();
    List<Student> findByLastNameDesc();
    List<Student> findByFirstNameAsc();
    List<Student> findByFirstNameDesc();
    List<Student> findByLastname(String lastName);
    List<Student> findByFirstname(String firstName);
    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();
}