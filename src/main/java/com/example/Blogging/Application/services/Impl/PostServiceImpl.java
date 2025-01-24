package com.example.Blogging.Application.services.Impl;

import com.example.Blogging.Application.entities.Category;
import com.example.Blogging.Application.entities.Post;
import com.example.Blogging.Application.entities.User;
import com.example.Blogging.Application.exceptions.ResourceNotFoundException;
import com.example.Blogging.Application.payloads.CategoryDto;
import com.example.Blogging.Application.payloads.PostDto;
import com.example.Blogging.Application.payloads.UserDto;
import com.example.Blogging.Application.repositories.CategoryRepo;
import com.example.Blogging.Application.repositories.PostRepo;
import com.example.Blogging.Application.repositories.UserRepo;
import com.example.Blogging.Application.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CategoryRepo catRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public PostDto createAPost(PostDto postDto, int userId, int categoryId) {
        postDto.setAddedDate(new Date());
        postDto.setImageName("Default.png");

        Category category= this.catRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" , "CatgeoryID" , categoryId));

        User user  = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User" , "userId" , userId));

        CategoryDto categoryDto = this.modelMapper.map(category , CategoryDto.class);

        UserDto userDto = this.modelMapper.map(user , UserDto.class);


        postDto.setCategoryDto(categoryDto);
        postDto.setUserDto(userDto);



        Post savedPost  = this.postRepo.save(this.modelMapper.map(postDto , Post.class));

        return this.modelMapper.map(savedPost , PostDto.class);
    }

    @Override
    public PostDto updateApost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deleteAPost(int postId) {

    }

    @Override
    public PostDto getApost(int postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return List.of();
    }

    @Override
    public List<PostDto> getAllPostsByUser(int userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        List<Post> posts = this.postRepo.findAllByUser(user);

        List<PostDto> postDtos = posts.stream().map(post -> {
            PostDto postDto = this.modelMapper.map(post, PostDto.class);
            postDto.setUserDto(this.modelMapper.map(post.getUser(), UserDto.class));
            postDto.setCategoryDto(this.modelMapper.map(post.getCategory(), CategoryDto.class));
            return postDto;
        }).collect(Collectors.toList());

        return postDtos;
    }


    @Override
    public List<PostDto> getAllPostsInACategory(int categoryId) {
        Category cat= this.catRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" , "categoryId" , categoryId));

        List<Post> posts = this.postRepo.findAllByCategory(cat);

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post , PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }
}
