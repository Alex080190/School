package com.example.school.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
@Data
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "year_of_study")
    private int yearOfStudy;

    @OneToOne(mappedBy = "nameOfTeacherClass")
    private Teacher classroomTeacher;
    @OneToMany(mappedBy = "classId")
    private List<Student> studentList;

    public Class() {
    }
}
