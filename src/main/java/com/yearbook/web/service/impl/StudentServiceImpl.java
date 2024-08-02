package com.yearbook.web.service.impl;

import com.yearbook.web.dto.StudentDto;
import com.yearbook.web.models.Student;
import com.yearbook.web.repository.StudentRepository;
import com.yearbook.web.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::mapToStudentDto).collect(Collectors.toList());
    }



    public StudentDto mapToStudentDto(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .photourl(student.getPhotourl())
                .name(student.getName())
                .quote(student.getQuote())
                .build();
    }
}
