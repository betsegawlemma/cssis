package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Parent;
import com.betsegaw.cssis.exceptions.NotFoundException;
import com.betsegaw.cssis.repositories.ParentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public Set<Parent> findAll() {
        Set<Parent> parents = new HashSet<>();
        parentRepository.findAll().iterator().forEachRemaining(parents::add);
        return parents;
    }

    @Override
    public Parent findById(Long parentId) {
        Optional<Parent> parentOptional = parentRepository.findById(parentId);
        if(!parentOptional.isPresent()){
            throw new NotFoundException("Parent Not Found. For Id Value: " + parentId.toString());
        }
        return parentOptional.get();
    }

    @Override
    public Set<Parent> findByFirstName(String firstName) {
        Set<Parent> parents = new HashSet<>();
        parentRepository.findByFirstName(firstName).iterator().forEachRemaining(parents::add);
        return parents;
    }

    @Override
    public Set<Parent> findByMiddleName(String middleName) {
        Set<Parent> parents = new HashSet<>();
        parentRepository.findByMiddleName(middleName).iterator().forEachRemaining(parents::add);
        return parents;
    }

    @Override
    public Set<Parent> findByLastName(String lastName) {
        Set<Parent> parents = new HashSet<>();
        parentRepository.findByLastName(lastName).iterator().forEachRemaining(parents::add);
        return parents;
    }

    @Override
    public Set<Parent> findByFirstNameAndMiddleName(String firstName, String middleName) {
        Set<Parent> parents = new HashSet<>();
        parentRepository.findByFirstNameAndMiddleName(firstName,middleName).iterator().forEachRemaining(parents::add);
        return parents;
    }

    @Override
    public Set<Parent> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName) {
        Set<Parent> parents = new HashSet<>();
        parentRepository.findByFirstNameAndMiddleNameAndLastName(firstName,middleName,lastName).iterator()
                .forEachRemaining(parents::add);
        return parents;
    }

    @Override
    public Set<Parent> findByNationality(String nationality) {
        Set<Parent> parents = new HashSet<>();
        parentRepository.findByNationality(nationality).iterator().forEachRemaining(parents::add);
        return parents;
    }

    @Override
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public void deleteById(Long parentId) {
         parentRepository.deleteById(parentId);
    }
}
