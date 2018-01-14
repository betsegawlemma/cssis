package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.enums.Role;
import com.betsegaw.cssis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUserName(String userName);
    Optional<User> findByPhone(String phone);
    Optional<User> findByEmail(String email);
    Set<User> findByRole(Role role);
}
