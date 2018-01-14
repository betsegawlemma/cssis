package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Student;
import com.betsegaw.cssis.enums.Gender;
import com.betsegaw.cssis.exceptions.NotFoundException;
import com.betsegaw.cssis.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<Student> findAll() {
        Set<Student> students = new HashSet<>();
        studentRepository.findAll().iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Student findById(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(!studentOptional.isPresent()){
            throw new NotFoundException("Student Not Found. For Id Value: " + studentId.toString());
        }
        return studentOptional.get();
    }

    @Override
    public Student findByStudentId(String studentId) {
        Optional<Student> studentOptional = studentRepository.findByStudentId(studentId);
        if(!studentOptional.isPresent()){
            throw new NotFoundException("Student Not Found. For Student Id value: " + studentId);
        }
        return studentOptional.get();
    }

    @Override
    public Set<Student> findByFirstName(String firstName) {
        Set<Student> students = new HashSet<>();
        studentRepository.findByFirstName(firstName).iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Set<Student> findByMiddleName(String middleName) {
        Set<Student> students = new HashSet<>();
        studentRepository.findByMiddleName(middleName).iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Set<Student> findByLastName(String lastName) {
        Set<Student> students = new HashSet<>();
        studentRepository.findByLastName(lastName).iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Set<Student> findByFirstNameAndMiddleName(String firstName, String middleName) {
        Set<Student> students = new HashSet<>();
        studentRepository.findByFirstNameAndMiddleName(firstName,middleName).iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Set<Student> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName) {
        Set<Student> students = new HashSet<>();
        studentRepository.findByFirstNameAndMiddleNameAndLastName(firstName,middleName,lastName).iterator()
                .forEachRemaining(students::add);
        return students;
    }

    @Override
    public Set<Student> findByBirthDate(Date date) {
        Set<Student> students = new HashSet<>();
        studentRepository.findByBirthDate(date).iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Set<Student> findByRegistrationDate(Date date) {
        Set<Student> students = new HashSet<>();
        studentRepository.findByRegistrationDate(date).iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Set<Student> findByGender(Gender gender) {
        Set<Student> students = new HashSet<>();
        studentRepository.findByGender(gender).iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Set<Student> findByNationality(String nationality) {
        Set<Student> students = new HashSet<>();
        studentRepository.findByNationality(nationality).iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long studentId) {
          studentRepository.deleteById(studentId);
    }
}
