package com.example.Blogging.Application.payloads;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {

    private Integer categoryId;
    private String categoryTitle;
    private String categoryDesc;
    private List<PostDto> posts = new ArrayList<>();

    // Default Constructor
    public CategoryDto() {
    }

    // All-Args Constructor
    public CategoryDto(Integer categoryId, String categoryTitle, String categoryDesc, List<PostDto> posts) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryDesc = categoryDesc;
        this.posts = posts;
    }

    // Getter and Setter for categoryId
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    // Getter and Setter for categoryTitle
    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    // Getter and Setter for categoryDesc
    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    // Getter and Setter for posts
    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryId=" + categoryId +
                ", categoryTitle='" + categoryTitle + '\'' +
                ", categoryDesc='" + categoryDesc + '\'' +
                ", posts=" + posts +
                '}';
    }
}
