package com.example.Blogging.Application.services;

import com.example.Blogging.Application.payloads.CategoryDto;
import com.example.Blogging.Application.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
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
