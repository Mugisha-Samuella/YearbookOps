package com.yearbook.web.service;

import com.yearbook.web.dto.StudentDto;
import com.yearbook.web.models.Student;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface StudentService {



    List<StudentDto> findAllStudents();
    StudentDto saveStudent(StudentDto studentDto);

    Student create(StudentDto dto) throws BadRequestException;
    Student getStudentByName(String name)throws Exception;
}
