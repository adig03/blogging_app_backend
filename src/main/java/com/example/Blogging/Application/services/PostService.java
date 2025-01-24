package com.example.Blogging.Application.services;

import com.example.Blogging.Application.entities.Post;
import com.example.Blogging.Application.payloads.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {

    // create
    PostDto createAPost(PostDto postDto , int userId , int categoryId);

    // update
    PostDto updateApost(PostDto postDto , Integer postId);


    //delete
    void deleteAPost( int postId);


    //getAPost
    PostDto getApost(int postId);

    //getAllPosts
    List<PostDto> getAllPosts();

    // get all posts that user has posted
    List<PostDto> getAllPostsByUser(int userId);
    // get all posts under a specific category
    List<PostDto> getAllPostsInACategory(int categoryId);

















}
