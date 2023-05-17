package com.example.AngularBackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class CreateNewUserRequest {

    @Size(min=2,max=20)
    private String name;

    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})",
            message="field must be between 6-15  alphanumeric (lowercase uppercase) characters with at least one special character '@#$%'")
    private String password;
}
