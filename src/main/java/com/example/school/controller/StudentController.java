package com.example.school.controller;

import com.example.school.dto.StudentDTO;
import com.example.school.entity.Student;
import com.example.school.service.ClassService;
import com.example.school.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final ClassService classService;
    private final ModelMapper modelMapper;

    public StudentController(StudentService studentService, ClassService classService, ModelMapper modelMapper) {
        this.studentService = studentService;
        this.classService = classService;
        this.modelMapper = modelMapper;
    }
    @GetMapping()
    public List<StudentDTO> findAll(){
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student:studentService.findAll()) {
            studentDTOList.add(addNameOfClass(student));
        }
        return studentDTOList;
    }
    @GetMapping("/id/{id}")
    public StudentDTO findById(@PathVariable("id")long id) {
        Student student = studentService.findById(id);
        return addNameOfClass(student);
    }
    @GetMapping("/name/{name}")
    public List<StudentDTO> findByFirstname(@PathVariable("name")String firstname) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student :studentService.findByFirstname(firstname)) {
            studentDTOList.add(addNameOfClass(student));
        }
        return studentDTOList;
    }
    @GetMapping("/lastname/{lastname}")
    public List<StudentDTO> findByLastname (@PathVariable("lastname")String lastname) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student :studentService.findByLastname(lastname)) {
            studentDTOList.add(addNameOfClass(student));
        }
        return studentDTOList;
    }
    @GetMapping("/year/{yearOfBirth}")
    public List<StudentDTO> findByYearOfBirth (@PathVariable("yearOfBirth")int yearOfBirth) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student :studentService.findByYearOfBirth(yearOfBirth)) {
            studentDTOList.add(addNameOfClass(student));
        }
        return studentDTOList;
    }
    @GetMapping("/sex/{sex}")
    public List<StudentDTO> findBySex (@PathVariable("sex")String sex) {

        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student :studentService.findBySex(sex)) {
            studentDTOList.add(addNameOfClass(student));
        }
        return studentDTOList;
    }
    @PostMapping("/add")
    public String save(@RequestBody StudentDTO studentDTO){
        Student student = convertToStudent(studentDTO);
        student.setClassId(classService.findById(studentDTO.getClassIndex()));
        studentService.save(student);
        System.out.println(studentDTO);
        return "New student " + studentDTO.getFirstname() + " " + studentDTO.getLastname() + " added";
    }
    @PatchMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @RequestBody StudentDTO studentDTO) {
        Student updatedStudent= studentService.findById(id);
        updatedStudent.setFirstname(studentDTO.getFirstname());
        updatedStudent.setLastname(studentDTO.getLastname());
        updatedStudent.setPatronymic(studentDTO.getPatronymic());
        updatedStudent.setYearOfBirth(studentDTO.getYearOfBirth());
        updatedStudent.setSex(studentDTO.getSex());
        updatedStudent.setClassId(classService.findById(studentDTO.getClassIndex()));

        studentService.update(updatedStudent);
        return "Student " + updatedStudent.getFirstname() + " " + updatedStudent.getLastname() + " is updated";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        studentService.delete(id);
        return "Student with id: " + id + " - deleted";
    }

    private Student convertToStudent(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }
    private StudentDTO convertToStudentDTO(Student student) {

        return modelMapper.map(student, StudentDTO.class);
    }
    private StudentDTO addNameOfClass(Student student){
        StudentDTO studentDTO = convertToStudentDTO(student);
        studentDTO.setNameOfClass(student.getClassId().getYearOfStudy() + student.getClassId().getName());
        return studentDTO;
    }

}
