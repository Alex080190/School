package com.example.school.dto;

import com.example.school.entity.Class;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@JsonIgnoreProperties(value = "classIndex", allowSetters = true)
public class StudentDTO {
    private String firstname;

    private String lastname;

    private String patronymic;

    private int yearOfBirth;

    private String sex;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    @JsonIgnore
    private Class classId;

    private String nameOfClass;

    @JsonProperty("classIndex")
    private int classIndex;


    public int getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }




}
