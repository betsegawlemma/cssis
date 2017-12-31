package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;
    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String placeOfBirth;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String nationality;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Lob
    private Byte[] photo;

    private String vision;

    private Address address;

    @ManyToMany
    @JoinTable(name = "student_parent",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id"))
    private Set<Parent> parents = new HashSet<>();

    public Student addParent(Parent parent){
        this.parents.add(parent);
        parent.getStudents().add(this);
        return this;
    }

    public void removeParent(Parent parent){
        this.parents.remove(parent);
        parent.getStudents().remove(this);
    }

    @ElementCollection
    private Set<StudentStatus> studentStatuses;

    @ElementCollection
    private Set<Assessement> assessements;



}
