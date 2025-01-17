package com.example.Blogging.Application.services;

import com.example.Blogging.Application.payloads.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public interface UserService {





   UserDto createUser(UserDto user);

   UserDto updateUser(UserDto user , Integer userId);

   UserDto getUserById(Integer  userId);

   List<UserDto> getAllUsers();

   void deleteUser(Integer userId);
}
