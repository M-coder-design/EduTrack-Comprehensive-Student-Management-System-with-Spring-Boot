package net.javaguides.student_management_system.service;

import net.javaguides.student_management_system.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    void createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long id);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(Long id);
}
