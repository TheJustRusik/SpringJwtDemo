package org.kenuki.springjwtdemo.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDTO {
    @NotBlank(message = "Empty email!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotBlank(message = "Empty password!")
    @Size(min = 8, message = "Password must be at least 8 characters!")
    private String password;
}
