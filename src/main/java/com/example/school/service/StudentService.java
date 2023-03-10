package com.example.school.service;

import com.example.school.entity.Student;
import com.example.school.repository.ClassRepository;
import com.example.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public Student findById(long id){

        return studentRepository.findById(id).get();
    }
    public List<Student> findByFirstname(String firstname){

        return studentRepository.findByFirstname(firstname);
    }
    public List<Student> findByLastname(String lastname){

        return studentRepository.findByLastname(lastname);
    }
    public List<Student> findByYearOfBirth(int yearOfBirth){

        return studentRepository.findByYearOfBirth(yearOfBirth);
    }
    public List<Student> findBySex(String sex){

        return studentRepository.findBySex(sex);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void update(Student updatedStudent) {
        studentRepository.save(updatedStudent);
    }

    public void delete(long id) {
        studentRepository.deleteById(id);
    }
}
