package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.enums.Gender;
import com.betsegaw.cssis.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    Optional<Student> findByStudentId(String studentId);
    Set<Student> findByFirstName(String firstName);
    Set<Student> findByMiddleName(String middleName);
    Set<Student> findByLastName(String lastName);
    Set<Student> findByFirstNameAndMiddleName(String firstName, String middleName);
    Set<Student> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
    Set<Student> findByBirthDate(Date date);
    Set<Student> findByGender(Gender gender);
    Set<Student> findByRegistrationDate(Date registrationDate);
    Set<Student> findByNationality(String nationality);
}
