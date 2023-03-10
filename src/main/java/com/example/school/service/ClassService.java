package com.example.school.service;

import com.example.school.entity.Class;
import com.example.school.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }
    public List<Class> findAll() {
       return classRepository.findAll();
    }

    public Class findById(long id) {
        return classRepository.findById(id).get();
    }
    public Class findByName(String name) {
        return classRepository.findByName(name);
    }
    public Class findByYearOfStudy(int year) {
        return classRepository.findByYearOfStudy(year);
    }

    public void save(Class cl) {
        classRepository.save(cl);
    }
    public void update(Class cl){
        classRepository.save(cl);
    }

    public void delete(long id) {
        classRepository.deleteById(id);
    }
}
