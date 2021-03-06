package com.betsegaw.cssis.services;

import com.betsegaw.cssis.enums.Gender;
import com.betsegaw.cssis.entities.Student;
import java.util.Date;
import java.util.Set;

public interface StudentService {
    public Set<Student> findAll();
    public Student findById(Long studentId);
    public Student findByStudentId(String studentId);
    public Set<Student> findByFirstName(String firstName);
    public Set<Student> findByMiddleName(String middleName);
    public Set<Student> findByLastName(String lastName);
    public Set<Student> findByFirstNameAndMiddleName(String firstName, String middleName);
    public Set<Student> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
    public Set<Student> findByBirthDate(Date date);
    public Set<Student> findByRegistrationDate(Date date);
    public Set<Student> findByGender(Gender gender);
    public Set<Student> findByNationality(String nationality);
    public Student save(Student student);
    public void deleteById(Long studentId);
}
