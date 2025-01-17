package com.example.Blogging.Application.services.Impl;

import com.example.Blogging.Application.entities.User;
import com.example.Blogging.Application.exceptions.ResourceNotFoundException;
import com.example.Blogging.Application.payloads.UserDto;
import com.example.Blogging.Application.repositories.UserRepo;
import com.example.Blogging.Application.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class UsesServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
     User user = this.dtoToUser(userDto);
     User savedUser = this.repo.save(user);
     return this.UserToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

       User user =  this.repo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"  , "id" , userId));

       user.setName(userDto.getName());
       user.setEmail(userDto.getEmail());
       user.setPassword(userDto.getPassword());
       user.setAbout(user.getAbout());

       User updatedUser = this.repo.save(user);
       UserDto userDto1 = this.UserToDto(updatedUser);
       return userDto1;



    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User" , "Id" , userId));
        return this.UserToDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> Users = this.repo.findAll();

        List<UserDto> userDtos = Users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());




        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        this.repo.delete(user);

    }



    private User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto , User.class);
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());

        return user;

    }

    private UserDto UserToDto(User user){
        UserDto userDto = this.modelMapper.map(user , UserDto.class);
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setAbout(user.getAbout());
//        userDto.setPassword(user.getPassword());

        return userDto;

    }
}
