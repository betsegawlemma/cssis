package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Staff;

import java.util.Set;

public interface StaffService {
    public Set<Staff> findAll();
    public Staff findByStaffId(String staffId);
    public Staff findById(Long staffId);
    public Set<Staff> findByFirstName(String firstName);
    public Set<Staff> findByMiddleName(String middleName);
    public Set<Staff> findByLastName(String lastName);
    public Set<Staff> findByFirstNameAndMiddleName(String firstName, String middleName);
    public Set<Staff> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
    public Staff save(Staff staff);
    public void deleteById(Long staffId);
}
