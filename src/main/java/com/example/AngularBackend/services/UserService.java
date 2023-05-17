package com.example.AngularBackend.services;

import com.example.AngularBackend.models.CreateNewUserRequest;
import com.example.AngularBackend.models.FindUserRequest;
import com.example.AngularBackend.models.UserEntity;
import com.example.AngularBackend.models.UserResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse createUser(CreateNewUserRequest req) {

        Optional<UserEntity> foundUser= this.userRepository.findByName(req.getName());

        if(foundUser.isPresent()){
            throw new UserAlreadyExistsException("User : "+req.getName()+" Already exists");
        }

        UserEntity savedUser= this.userRepository.save(this.userMapper.toEntity(req));

        return this.userMapper.toResponse(savedUser);

    }

    public UserResponse findUser(FindUserRequest req){

        Optional<UserEntity> foundUser= this.userRepository.findByName(req.getName());

        if(foundUser.isEmpty()) {
            throw new UserNotFoundException("User : "+req.getName()+" Does not exist");
        }

        return this.userMapper.toResponse(foundUser.get());
    }
}
