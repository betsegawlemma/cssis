package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Long> {
    Set<Parent> findByFirstName(String firstName);
    Set<Parent> findByMiddleName(String middleName);
    Set<Parent> findByLastName(String lastName);
    Set<Parent> findByFirstNameAndMiddleName(String firstName, String middleName);
    Set<Parent> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
    Set<Parent> findByNationality(String nationality);
}
