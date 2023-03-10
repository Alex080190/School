package com.example.school.controller;

import com.example.school.dto.StudentDTO;
import com.example.school.dto.TeacherDTO;
import com.example.school.entity.Student;
import com.example.school.entity.Teacher;
import com.example.school.service.ClassService;
import com.example.school.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final ModelMapper modelMapper;
    private final ClassService classService;

    public TeacherController(TeacherService teacherService, ModelMapper modelMapper, ClassService classService) {
        this.teacherService = teacherService;
        this.modelMapper = modelMapper;
        this.classService = classService;
    }
    @GetMapping
    public List<TeacherDTO> findAll(){
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher teacher :teacherService.findAll()) {
            teacherDTOList.add(convertToTeacherDTO(teacher));
        }
        return teacherDTOList;
    }
    @GetMapping("/id/{id}")
    public TeacherDTO findById(@PathVariable("id")long id) {
        return convertToTeacherDTO(teacherService.findById(id));
    }
    @GetMapping("/name/{name}")
    public List<TeacherDTO> findByFirstname(@PathVariable("name")String firstname) {
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher teacher :teacherService.findByFirstname(firstname)) {
            teacherDTOList.add(convertToTeacherDTO(teacher));
        }
        return teacherDTOList;
    }
    @GetMapping("/lastname/{lastname}")
    public List<TeacherDTO> findByLastname (@PathVariable("lastname")String lastname) {
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher teacher :teacherService.findByLastname(lastname)) {
            teacherDTOList.add(convertToTeacherDTO(teacher));
        }
        return teacherDTOList;
    }
    @GetMapping("/year/{yearOfBirth}")
    public List<TeacherDTO> findByYearOfBirth (@PathVariable("yearOfBirth")int yearOfBirth) {
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher teacher :teacherService.findByYearOfBirth(yearOfBirth)) {
            teacherDTOList.add(convertToTeacherDTO(teacher));
        }
        return teacherDTOList;
    }

    @GetMapping("/sex/{sex}")
    public List<TeacherDTO> findBySex (@PathVariable("sex")String sex) {
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher teacher :teacherService.findBySex(sex)) {
            teacherDTOList.add(convertToTeacherDTO(teacher));
        }
        return teacherDTOList;
    }

    @GetMapping("/subject/{subject}")
    public List<TeacherDTO> findBySubject (@PathVariable("subject")String subject) {
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher teacher :teacherService.findBySubject(subject)) {
            teacherDTOList.add(convertToTeacherDTO(teacher));
        }
        return teacherDTOList;
    }
    @PostMapping("/add")
    public String save(@RequestBody TeacherDTO teacherDTO){
        Teacher teacher = convertToTeacher(teacherDTO);
        teacher.setNameOfTeacherClass(classService.findById(teacherDTO.getClassIndex()));
        teacherService.save(teacher);
        return "New teacher " + teacherDTO.getFirstname() + " " + teacherDTO.getLastname() + " added";
    }
    @PatchMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @RequestBody TeacherDTO teacherDTO) {
        Teacher updatedTeacher= teacherService.findById(id);
        updatedTeacher.setFirstname(teacherDTO.getFirstname());
        updatedTeacher.setLastname(teacherDTO.getLastname());
        updatedTeacher.setPatronymic(teacherDTO.getPatronymic());
        updatedTeacher.setYearOfBirth(teacherDTO.getYearOfBirth());
        updatedTeacher.setSex(teacherDTO.getSex());
        updatedTeacher.setSubject(teacherDTO.getSubject());
        updatedTeacher.setNameOfTeacherClass(classService.findById(teacherDTO.getClassIndex()));

        teacherService.update(updatedTeacher);
        return "Teacher " + updatedTeacher.getFirstname() + " " + updatedTeacher.getLastname() + " is updated";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        teacherService.delete(id);
        return "Teacher with id: " + id + " - deleted";
    }
    private Teacher convertToTeacher(TeacherDTO teacherDTO) {
        return modelMapper.map(teacherDTO, Teacher.class);
    }
    private TeacherDTO convertToTeacherDTO(Teacher teacher) {
        return modelMapper.map(teacher, TeacherDTO.class);
    }

}
