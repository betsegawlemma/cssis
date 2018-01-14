package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Parent;

import java.util.Set;

public interface ParentService {
    public Set<Parent> findAll();
    public Parent findById(Long parentId);
    public Set<Parent> findByFirstName(String firstName);
    public Set<Parent> findByMiddleName(String middleName);
    public Set<Parent> findByLastName(String lastName);
    public Set<Parent> findByFirstNameAndMiddleName(String firstName, String middleName);
    public Set<Parent> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
    public Set<Parent> findByNationality(String nationality);
    public Parent save(Parent parent);
    public void deleteById(Long parentId);
}
