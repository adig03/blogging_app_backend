package com.example.Blogging.Application.services.Impl;

import com.example.Blogging.Application.entities.Category;
import com.example.Blogging.Application.exceptions.ResourceNotFoundException;
import com.example.Blogging.Application.payloads.CategoryDto;
import com.example.Blogging.Application.repositories.CategoryRepo;
import com.example.Blogging.Application.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo cat_repo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategoryDto(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);

        Category addedCat = this.cat_repo.save(cat);

        return this.modelMapper.map(addedCat , CategoryDto.class);


    }

    @Override
    public CategoryDto updateCategoryDto(CategoryDto categoryDto, Integer cat_id) {

        Category cat = this.cat_repo.findById(cat_id ).orElseThrow(() -> new ResourceNotFoundException("Category" , "Category_id" , cat_id));


        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDesc(categoryDto.getCategoryDesc());

        Category savedCategory = this.cat_repo.save(cat);
        return this.modelMapper.map(savedCategory , CategoryDto.class);

    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categories = this.cat_repo.findAll();
        List<CategoryDto> cats = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());

        return cats;
    }

    @Override
    public void deleteCategory(Integer Cat_id) {

        Category cat = this.cat_repo.findById(Cat_id).orElseThrow(() -> new ResourceNotFoundException("Category" , "CategoryId" , Cat_id));

        this.cat_repo.delete(cat);

    }

    @Override
    public CategoryDto getACategory(Integer Cat_id) {
        Category cat = this.cat_repo.findById(Cat_id ).orElseThrow(() -> new ResourceNotFoundException("Category" , "Category_id" , Cat_id));
        return this.modelMapper.map(cat , CategoryDto.class);

    }
}
