package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Long> {
    Optional<Parent> findByFirstName(String firstName);
    Optional<Parent> findByLastName(String lastName);
    Set<Parent> findByNationality(String nationality);
}
