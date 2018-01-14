package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Teacher;
import com.betsegaw.cssis.exceptions.NotFoundException;
import com.betsegaw.cssis.repositories.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Set<Teacher> findAll() {
        Set<Teacher> teachers = new HashSet<>();
        teacherRepository.findAll().iterator().forEachRemaining(teachers::add);
        return teachers;
    }

    @Override
    public Teacher findByTeacherId(String teacherId) {
        Optional<Teacher> teacherOptional = teacherRepository.findByTeacherId(teacherId);
        if(!teacherOptional.isPresent()){
            throw new NotFoundException("Teacher Not Found. For Teacher Id value: " + teacherId);
        }
        return teacherOptional.get();
    }

    @Override
    public Teacher findById(Long teacherId) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacherId);
        if(!teacherOptional.isPresent()){
            throw new NotFoundException("Teacher Not Found. For Id value: " + teacherId.toString());
        }
        return teacherOptional.get();
    }

    @Override
    public Set<Teacher> findByFirstName(String firstName) {
        Set<Teacher> teachers = new HashSet<>();
        teacherRepository.findByFirstName(firstName).iterator().forEachRemaining(teachers::add);
        return teachers;
    }

    @Override
    public Set<Teacher> findByMiddleName(String middleName) {
        Set<Teacher> teachers = new HashSet<>();
        teacherRepository.findByMiddleName(middleName).iterator().forEachRemaining(teachers::add);
        return teachers;
    }

    @Override
    public Set<Teacher> findByLastName(String lastName) {
        Set<Teacher> teachers = new HashSet<>();
        teacherRepository.findByLastName(lastName).iterator().forEachRemaining(teachers::add);
        return teachers;
    }

    @Override
    public Set<Teacher> findByFirstNameAndMiddleName(String firstName, String middleName) {
        Set<Teacher> teachers = new HashSet<>();
        teacherRepository.findByFirstNameAndMiddleName(firstName,middleName).iterator().forEachRemaining(teachers::add);
        return teachers;
    }

    @Override
    public Set<Teacher> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName) {
        Set<Teacher> teachers = new HashSet<>();
        teacherRepository.findByFirstNameAndMiddleNameAndLastName(firstName,middleName,lastName)
                .iterator().forEachRemaining(teachers::add);
        return teachers;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(Long teacherId) {
       teacherRepository.deleteById(teacherId);
    }
}
