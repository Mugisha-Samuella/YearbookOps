package com.yearbook.web.controllers;

import org.springframework.ui.Model;
import com.yearbook.web.dto.StudentDto;
import com.yearbook.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

   @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model){
    List<StudentDto> students = studentService.findAllStudents();
    model.addAttribute("students", students);
    return "students-list";
   }
}