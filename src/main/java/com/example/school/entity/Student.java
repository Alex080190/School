package com.example.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "sex")
    private String sex;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    @JsonIgnore
    private Class classId;

}
