package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>{
    Optional<Teacher> findByTeacherId(String teacherId);
    Set<Teacher> findByFirstName(String firstName);
    Set<Teacher> findByLastName(String lastName);
    Set<Teacher> findByNationality(String nationality);
}
