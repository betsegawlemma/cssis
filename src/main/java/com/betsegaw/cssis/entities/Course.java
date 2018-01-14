package com.betsegaw.cssis.entities;

import com.betsegaw.cssis.enums.Field;
import com.betsegaw.cssis.enums.GradeGroup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode;

    @Lob
    @NotNull
    @NotBlank
    private String subject;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private GradeGroup gradeGroup;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Field field;
}
