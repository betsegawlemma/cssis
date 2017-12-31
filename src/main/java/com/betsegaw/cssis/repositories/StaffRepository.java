package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
    Optional<Staff> findByStaffId(String staffId);
    Set<Staff> findByFirstName(String firstName);
    Set<Staff> findByLastName(String lastName);
    Set<Staff> findByNationality(String nationality);
}
