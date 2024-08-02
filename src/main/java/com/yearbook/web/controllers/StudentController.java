package com.yearbook.web.controllers;

import com.yearbook.web.models.Student;
import org.springframework.ui.Model;
import com.yearbook.web.dto.StudentDto;
import com.yearbook.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

   @GetMapping("/students/create")
    public String createStudent(Model model) {
       Student student = new Student();
       model.addAttribute("students", student);
       return "students-create";
   }

   @PostMapping("students/new")
    public String saveStudent(@ModelAttribute("student") Student student){
       StudentService.saveStudent(studentDto);
       return "redirect:/students";
   }
}