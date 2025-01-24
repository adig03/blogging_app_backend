package com.example.Blogging.Application.repositories;

import com.example.Blogging.Application.entities.Category;
import com.example.Blogging.Application.entities.Post;
import com.example.Blogging.Application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface PostRepo extends JpaRepository<Post, Integer> {


    List<Post> findAllByUser(User user);

    List<Post> findAllByCategory(Category category);




}
