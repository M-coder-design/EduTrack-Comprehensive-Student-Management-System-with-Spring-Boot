package net.javaguides.student_management_system.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.student_management_system.dto.StudentDto;
import net.javaguides.student_management_system.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model)
    {
        List<StudentDto> studentDtoList = studentService.getAllStudents();

        model.addAttribute("students", studentDtoList);

        return "students";
    }

    @GetMapping("student/new")
    public String newStudent(Model model)
    {
        StudentDto studentDto = new StudentDto();

        model.addAttribute("student",studentDto);

        return "create-student";
    }

    @PostMapping("students")
    public String createStudent(@Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult bindingResult,
                                Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("student",studentDto);
            return "create-student";
        }
        studentService.createStudent(studentDto);

        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/edit")
    public String getStudent(@PathVariable("studentId") Long id,Model model)
    {
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student",studentDto);
        return "edit-student";
    }

    @PostMapping("students/{studentId}")
    public String editStudent(@Valid @ModelAttribute("student") StudentDto studentDto, @PathVariable("studentId") Long id, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("student",studentDto);
            return "edit-student";
        }

        studentDto.setId(id);

        studentService.updateStudent(studentDto);

        return "redirect:/students";
    }

    @GetMapping("students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long id)
    {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long id, Model model)
    {
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student",studentDto);
        return "view-student";
    }
}
