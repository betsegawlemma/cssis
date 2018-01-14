package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Staff;
import com.betsegaw.cssis.exceptions.NotFoundException;
import com.betsegaw.cssis.repositories.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class StaffServiceImpl implements StaffService{
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Set<Staff> findAll() {
        Set<Staff> staff = new HashSet<>();
        staffRepository.findAll().iterator().forEachRemaining(staff::add);
        return staff;
    }

    @Override
    public Staff findByStaffId(String staffId) {
        Optional<Staff> staffOptional = staffRepository.findByStaffId(staffId);
        if(!staffOptional.isPresent()){
            throw new NotFoundException("Staff Not Found. For Staff Id value: " + staffId);
        }
        return staffOptional.get();
    }

    @Override
    public Staff findById(Long staffId) {
        Optional<Staff> staffOptional = staffRepository.findById(staffId);
        if(!staffOptional.isPresent()){
            throw new NotFoundException("Staff Not Found. For Id value: " + staffId);
        }
        return staffOptional.get();
    }

    @Override
    public Set<Staff> findByFirstName(String firstName) {
        Set<Staff> staff = new HashSet<>();
        staffRepository.findByFirstName(firstName).iterator().forEachRemaining(staff::add);
        return staff;
    }

    @Override
    public Set<Staff> findByMiddleName(String middleName) {
        Set<Staff> staff = new HashSet<>();
        staffRepository.findByMiddleName(middleName).iterator().forEachRemaining(staff::add);
        return staff;
    }

    @Override
    public Set<Staff> findByLastName(String lastName) {
        Set<Staff> staff = new HashSet<>();
        staffRepository.findByLastName(lastName).iterator().forEachRemaining(staff::add);
        return staff;
    }

    @Override
    public Set<Staff> findByFirstNameAndMiddleName(String firstName, String middleName) {
        Set<Staff> staff = new HashSet<>();
        staffRepository.findByFirstNameAndMiddleName(firstName,middleName).iterator().forEachRemaining(staff::add);
        return staff;
    }

    @Override
    public Set<Staff> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName) {
        Set<Staff> staff = new HashSet<>();
        staffRepository.findByFirstNameAndMiddleNameAndLastName(firstName,middleName,lastName).iterator()
                .forEachRemaining(staff::add);
        return staff;
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteById(Long staffId) {
         staffRepository.deleteById(staffId);
    }
}
