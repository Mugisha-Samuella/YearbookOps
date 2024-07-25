package com.yearbook.web.service;

import com.yearbook.web.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAllStudents();
}
