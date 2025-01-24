package com.example.Blogging.Application.payloads;

import java.util.Date;

public class PostDto {

    private Integer postId;
    private String postTitle;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto categoryDto;
    private UserDto userDto;

    // Default Constructor
    public PostDto() {
    }

    // Getter and Setter for postId
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    // Getter and Setter for postTitle
    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    // Getter and Setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and Setter for imageName
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    // Getter and Setter for addedDate
    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    // Getter and Setter for categoryDto
    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    // Getter and Setter for userDto
    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
