package com.validation.exception.demo.controller;

import com.validation.exception.demo.dto.UserRequest;
import com.validation.exception.demo.entity.User;
import com.validation.exception.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> saveUser(@RequestBody @Valid  UserRequest userRequest){
        return new ResponseEntity<User>(userService.saveUser(userRequest), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){

        return  ResponseEntity.ok(userService.getAllUser());
    }

}
