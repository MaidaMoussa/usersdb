package com.example.AngularBackend.controllers;

import com.example.AngularBackend.models.CreateNewUserRequest;
import com.example.AngularBackend.models.FindUserRequest;
import com.example.AngularBackend.models.UserResponse;
import com.example.AngularBackend.services.UserAlreadyExistsException;
import com.example.AngularBackend.services.UserMapper;
import com.example.AngularBackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateNewUserRequest req) throws UserAlreadyExistsException {


          return  new ResponseEntity<UserResponse>(this.userService.createUser(req), HttpStatus.OK);

    }

    @GetMapping("/{name}")
    public ResponseEntity<UserResponse> findUser(@PathVariable String name){

        return  new ResponseEntity<UserResponse>(this.userService.findUser(new FindUserRequest(name)),HttpStatus.OK );
    }


}
