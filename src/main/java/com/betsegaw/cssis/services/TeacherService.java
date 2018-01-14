package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Teacher;

import java.util.Set;

public interface TeacherService {
    public Set<Teacher> findAll();
    public Teacher findByTeacherId(String teacherId);
    public Teacher findById(Long teacherId);
    public Set<Teacher> findByFirstName(String firstName);
    public Set<Teacher> findByMiddleName(String middleName);
    public Set<Teacher> findByLastName(String lastName);
    public Set<Teacher> findByFirstNameAndMiddleName(String firstName, String middleName);
    public Set<Teacher> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
    public Teacher save(Teacher teacher);
    public void deleteById(Long teacherId);
}
