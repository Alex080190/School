package com.example.school.repository;

import com.example.school.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
        Class findByName(String name);
        Class findByYearOfStudy(int year);


}
