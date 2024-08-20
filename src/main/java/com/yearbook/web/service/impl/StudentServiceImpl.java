    package com.yearbook.web.service.impl;

    import com.yearbook.web.dto.StudentDto;
    import com.yearbook.web.models.Student;
    import com.yearbook.web.repository.StudentRepository;
    import com.yearbook.web.service.StudentService;
    import org.apache.coyote.BadRequestException;
    import org.springframework.data.crossstore.ChangeSetPersister;
    import org.springframework.stereotype.Service;

    import javax.naming.Name;
    import java.util.List;
    import java.util.Objects;
    import java.util.Optional;
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

        @Override
        public StudentDto saveStudent(StudentDto studentDto) {
            return saveStudent(studentDto);
        }

        public Student create(StudentDto dto) throws BadRequestException {
            try {
                System.out.println(dto.toString());
                if (Objects.equals(dto.getName(), "") || Objects.equals(dto.getQuote(), "") || dto.getQuote() == null || Objects.equals(dto.getPhotourl(), "")) {
                    throw new BadRequestException("All student info are required.");
                }

                Optional<Student> eStudent = studentRepository.findByName(dto.getName());

                if(eStudent.isPresent()){
                    throw new BadRequestException("Student with this name already exists.");
                }

//                if(studentRepository.findByName(dto.getName()) == dto.getName()) throws Exception{
//                    try {
//                        System.out.println("Student already exists.");
//                    }catch (Exception e){
//                        throw e;
//                    }
//                }

                Student student = new Student();
                student.setName(dto.getName());
                return studentRepository.save(student);
            }catch (BadRequestException e){
                throw e;
            }finally {
                System.out.println("Samuella");
            }
        }

        @Override
        public Student getStudentByName(String name)throws Exception{
            try{
                Student student = studentRepository.findByName(name).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
                return student;
            }catch(Exception e){
              throw  e;
            }
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
