package com.example.Blogging.Application.controllers;

import com.example.Blogging.Application.entities.Post;
import com.example.Blogging.Application.payloads.PostDto;
import com.example.Blogging.Application.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class PostController {

    @Autowired
    private PostService postService;



    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                              @PathVariable Integer userId ,
                                              @PathVariable Integer categoryId){

    PostDto savedPostDto =  this.postService.createAPost(postDto , userId , categoryId);

    return new ResponseEntity<>(savedPostDto , HttpStatus.CREATED);





    }

    // get All posts by a user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getAllPostsByUser(@PathVariable int userId){

        List<PostDto> postDtos = this.postService.getAllPostsByUser(userId);

        return new ResponseEntity<>(postDtos , HttpStatus.OK);
    }
    @GetMapping("/categories/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getAllPostsByCategory(@PathVariable int categoryId){

        List<PostDto> postDtos = this.postService.getAllPostsInACategory(categoryId);

        return new ResponseEntity<>(postDtos , HttpStatus.OK);
    }







}
