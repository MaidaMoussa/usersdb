package com.example.AngularBackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
public class CreateNewUserRequest {

    @Length(min=2,max=20)
    private String name;

    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})")
    private String password;
}
