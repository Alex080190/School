package com.example.school.controller;

import com.example.school.dto.ClassDTO;
import com.example.school.entity.Class;
import com.example.school.service.ClassService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/class")
public class ClassController {
    private final ClassService classService;
    private final ModelMapper modelMapper;

    public ClassController(ClassService classService, ModelMapper modelMapper) {
        this.classService = classService;
        this.modelMapper = modelMapper;
    }
    @GetMapping()
    public List<ClassDTO> findAll(){
        List<ClassDTO> classDTOList = new ArrayList<>();
        for (Class cl : classService.findAll()) {
            classDTOList.add(convertToClassDTO(cl));
        }
        return classDTOList;
    }
    @GetMapping("/id/{id}")
    public ClassDTO findById(@PathVariable("id") long id) {

        return convertToClassDTO(classService.findById(id));
    }
    @GetMapping("/name/{name}")
    public ClassDTO findByName(@PathVariable("name") String name) {

        return convertToClassDTO(classService.findByName(name));
    }
    @GetMapping("/year/{year}")
    public ClassDTO findByYear(@PathVariable("year") int year) {
        return convertToClassDTO(classService.findByYearOfStudy(year));
    }
    @PostMapping("/add")
    public String save(@RequestBody ClassDTO classDTO){
        classService.save(convertToClass(classDTO));
        return "New class " + classDTO.getName() + " added";
    }
    @PatchMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @RequestBody ClassDTO classDTO) {
        Class updatedClass= classService.findById(id);
        updatedClass.setName(classDTO.getName());
        updatedClass.setYearOfStudy(classDTO.getYearOfStudy());
        classService.update(updatedClass);
        return "Class was updated";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        classService.delete(id);
        return "Class with id: " + id + " deleted";
    }

    private Class convertToClass(ClassDTO classDTO) {
        return modelMapper.map(classDTO, Class.class);
    }
    private ClassDTO convertToClassDTO(Class cl) {
        return modelMapper.map(cl, ClassDTO.class);
    }



}
