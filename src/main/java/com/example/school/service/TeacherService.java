package com.example.school.service;

import com.example.school.entity.Teacher;
import com.example.school.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(long id) {
        return teacherRepository.findById(id).get();
    }

    public List<Teacher> findByFirstname(String firstname) {
        return teacherRepository.findByFirstname(firstname);
    }

    public List<Teacher> findByLastname(String lastname) {
        return teacherRepository.findByLastname(lastname);
    }

    public List<Teacher> findByYearOfBirth(int yearOfBirth) {
        return teacherRepository.findByYearOfBirth(yearOfBirth);
    }

    public List<Teacher> findBySex(String sex) {
        return teacherRepository.findBySex(sex);
    }

    public List<Teacher> findBySubject(String subject) {
        return teacherRepository.findBySubject(subject);
    }

    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void update(Teacher updatedTeacher) {
        teacherRepository.save(updatedTeacher);
    }

    public void delete(long id) {
        teacherRepository.deleteById(id);
    }
}
