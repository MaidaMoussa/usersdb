package com.example.AngularBackend.controllers;

import com.example.AngularBackend.models.CreateNewUserRequest;
import com.example.AngularBackend.models.FindUserRequest;
import com.example.AngularBackend.models.UserResponse;
import com.example.AngularBackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid CreateNewUserRequest req)  {

          return  new ResponseEntity<>(this.userService.createUser(req), HttpStatus.OK);

    }

    @GetMapping("/{name}")
    public ResponseEntity<UserResponse> findUser(@PathVariable String name){

        return  new ResponseEntity<>(this.userService.findUser(new FindUserRequest(name)),HttpStatus.OK );
    }


}
