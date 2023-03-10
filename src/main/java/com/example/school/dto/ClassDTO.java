package com.example.school.dto;

import com.example.school.entity.Student;
import com.example.school.entity.Teacher;
import lombok.Data;


import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
public class ClassDTO {
    private String name;

    private int yearOfStudy;

    @OneToOne(mappedBy = "nameOfTeacherClass")
    private Teacher classroomTeacher;
    @OneToMany(mappedBy = "classId")
    private List<Student> studentList;
}
