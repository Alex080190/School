package com.example.school.repository;

import com.example.school.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByFirstname(String firstname);

    List<Teacher> findByLastname(String lastname);

    List<Teacher> findByYearOfBirth(int yearOfBirth);

    List<Teacher> findBySex(String sex);

    List<Teacher> findBySubject(String subject);
}
