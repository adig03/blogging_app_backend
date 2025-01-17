package com.example.Blogging.Application.repositories;

import com.example.Blogging.Application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends JpaRepository<User, Integer> {

}
