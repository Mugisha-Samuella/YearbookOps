package com.yearbook.web.service;

import com.yearbook.web.dto.StudentDto;
import com.yearbook.web.models.Student;

import java.util.List;

public interface StudentService {



    List<StudentDto> findAllStudents();
    StudentDto saveStudent(StudentDto studentDto);
}
