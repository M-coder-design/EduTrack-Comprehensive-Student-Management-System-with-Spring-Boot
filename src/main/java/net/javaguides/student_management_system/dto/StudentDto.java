package net.javaguides.student_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.bridge.Message;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;

    @NotEmpty(message = "first name cannot be empty")
    private String firstName;

    @NotEmpty(message = "last name cannot be empty")
    private String lastName;

    @Email(message = "Please enter a valid email")
    @NotEmpty(message = "email cannot be empty")
    private String email;
}
