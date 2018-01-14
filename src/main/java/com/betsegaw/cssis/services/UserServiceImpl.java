package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.User;
import com.betsegaw.cssis.enums.Role;
import com.betsegaw.cssis.exceptions.NotFoundException;
import com.betsegaw.cssis.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public User findById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new NotFoundException("User Not Found. For Id value: " + userId.toString());
        }
        return userOptional.get();
    }

    @Override
    public User findByUserName(String userName) {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if(!userOptional.isPresent()){
            throw new NotFoundException("User Not Found. For Username value: " + userName);
        }
        return userOptional.get();
    }

    @Override
    public User findByPhone(String phone) {
        Optional<User> userOptional = userRepository.findByPhone(phone);
        if(!userOptional.isPresent()){
            throw new NotFoundException("User Not Found. For Phone value: " + phone);
        }
        return userOptional.get();
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(!userOptional.isPresent()){
            throw new NotFoundException("User Not Found. For Email value: " + email);
        }
        return userOptional.get();
    }

    @Override
    public Set<User> findByRole(Role role) {
        Set<User> users = new HashSet<>();
        userRepository.findByRole(role).iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long userId) {
       userRepository.deleteById(userId);
    }
}
