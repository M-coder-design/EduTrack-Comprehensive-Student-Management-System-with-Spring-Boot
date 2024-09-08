package net.javaguides.student_management_system.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.student_management_system.dto.StudentDto;
import net.javaguides.student_management_system.entity.Student;
import net.javaguides.student_management_system.mapper.StudentMapper;
import net.javaguides.student_management_system.repository.StudentRepository;
import net.javaguides.student_management_system.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static net.javaguides.student_management_system.mapper.StudentMapper.mapToStudent;
import static net.javaguides.student_management_system.mapper.StudentMapper.mapToStudentDto;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        List<StudentDto> studentDtos = students.stream().map((student)-> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());

        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {

        Student student = mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long id) {

        Student student = studentRepository.findById(id).get();

        return mapToStudentDto(student);
    }

    @Override
    public void updateStudent(StudentDto studentDto) {

        Student student = studentRepository.save(mapToStudent(studentDto));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
