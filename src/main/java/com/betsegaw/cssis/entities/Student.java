package com.betsegaw.cssis.entities;

import com.betsegaw.cssis.enums.Gender;
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

    private String studentId; // Student Identification Number given by the school
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
    @CollectionTable(
            name = "student_status",
            joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "student_status")
    private Set<StudentStatus> studentStatuses;

    @OneToMany(mappedBy = "student")
    private Set<Assessment> assessments = new HashSet<>();;


    public Student addAssessment(Assessment assessement){
        this.assessments.add(assessement);
        assessement.setStudent(this);
        return this;
    }

    public void removeAssessment(Assessment assessement){
        this.assessments.remove(assessement);
        assessement.setStudent(null);
    }

}
