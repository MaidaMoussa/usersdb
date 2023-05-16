package com.example.AngularBackend.services;

import com.example.AngularBackend.models.CreateNewUserRequest;
import com.example.AngularBackend.models.UserEntity;
import com.example.AngularBackend.models.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(CreateNewUserRequest rep){

        UserEntity user=new UserEntity();
        user.setName(rep.getName());
        user.setPassword(rep.getPassword());

        return user;
    }

    public UserResponse toResponse(UserEntity user){
        return new UserResponse(user.getId(), user.getName());
    }

    public UserEntity toEntity(UserResponse response){

        UserEntity user=new UserEntity();
        user.setId(response.getId());
        user.setName(response.getName());

        return user;
    }
}
