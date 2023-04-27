package com.validation.exception.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotNull(message = "user name shouldn't be null")
    private String firstName;
    private String lastName;
    @Email(message = "Invalid email address")
    private String email;
    @NotBlank
    private String address;
}
