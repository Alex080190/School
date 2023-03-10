package com.example.school.dto;

import com.example.school.entity.Class;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Data
@JsonIgnoreProperties(value = "classIndex", allowSetters = true)
public class TeacherDTO {
    private String firstname;

    private String lastname;

    private String patronymic;

    private int yearOfBirth;

    private String sex;

    private String subject;

    @OneToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    @JsonIgnore
    private Class nameOfTeacherClass;
    @JsonProperty("classIndex")
    private int classIndex;
}
