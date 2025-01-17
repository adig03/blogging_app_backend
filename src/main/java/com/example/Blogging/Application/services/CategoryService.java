package com.example.Blogging.Application.services;

import com.example.Blogging.Application.payloads.CategoryDto;
import com.example.Blogging.Application.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CategoryService {



//create
 CategoryDto createCategoryDto(CategoryDto categoryDto);
//update
 CategoryDto updateCategoryDto(CategoryDto categoryDto , Integer cat_id);

 //get All Categories
    List<CategoryDto> getAllCategories();

    //delete

    void deleteCategory(Integer Cat_id);

    //get Cat by Id

    CategoryDto getACategory(Integer Cat_id);




}
