package com.example.Blogging.Application.controllers;


import com.example.Blogging.Application.entities.User;
import com.example.Blogging.Application.payloads.ApiResponse;
import com.example.Blogging.Application.payloads.UserDto;
import com.example.Blogging.Application.services.UserService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    //Post - create User
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto , HttpStatus.CREATED);
    }


    //Put - update User

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto , @PathVariable ("userId") Integer uid){

         UserDto updatedUser = this.userService.updateUser(userDto , uid );
         return new ResponseEntity<>(updatedUser , HttpStatus.OK);


    }






    // Delete - delete user

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return new ResponseEntity<>("Deleted" , HttpStatus.NO_CONTENT);
    }
    //GET - get all users
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getSingleUser(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    //Get - get user By id

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser (@PathVariable("userId") Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }






}
