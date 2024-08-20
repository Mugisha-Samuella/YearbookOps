package com.yearbook.web.controllers;

import com.yearbook.web.models.Student;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.yearbook.web.dto.StudentDto;
import com.yearbook.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

   @PostMapping("students/create-new")
   public ResponseEntity<Student> createStudent(@RequestBody() StudentDto dto)throws BadRequestException {
    return  ResponseEntity.ok(studentService.create(dto));
   }

   @PostMapping("students/new")
    public String saveStudent(@ModelAttribute("student") Student student){

       return "redirect:/students";
   }

   @GetMapping("/students/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable("name") String name)throws Exception {
       return ResponseEntity.ok(studentService.getStudentByName(name));
   }
}