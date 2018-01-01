package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Role;
import com.betsegaw.cssis.entities.User;

import java.util.Set;

public interface UserService {
    public Set<User> findAll();
    public User findById(Long userId);
    public User findByUserName(String userName);
    public User findByPhone(String phone);
    public User findByEmail(String email);
    public Set<User> findByRole(Role role);
    public User save(User user);
    public void deleteById(Long userId);
}
