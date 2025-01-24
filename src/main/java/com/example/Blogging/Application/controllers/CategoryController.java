package com.example.Blogging.Application.controllers;


import com.example.Blogging.Application.payloads.CategoryDto;
import com.example.Blogging.Application.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService cat_service;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createACategory(@RequestBody CategoryDto categoryDto){

        CategoryDto  createCategory = this.cat_service.createCategoryDto(categoryDto);

        return new ResponseEntity<>(createCategory , HttpStatus.CREATED);


    }


    //getByID
    @GetMapping("/{cat_id}")
    public ResponseEntity<CategoryDto> getACategory(@PathVariable Integer cat_id){
        CategoryDto getaCatDto = this.cat_service.getACategory(cat_id);

        return new ResponseEntity<>(getaCatDto , HttpStatus.OK);
    }
    //update
    @PutMapping("/{cat_id}")
    public ResponseEntity<CategoryDto> updateACategory(@RequestBody CategoryDto cat , @PathVariable Integer cat_id){
        CategoryDto updateCat = this.cat_service.updateCategoryDto(cat , cat_id);
        return new ResponseEntity<>(updateCat , HttpStatus.ACCEPTED);
    }

    //delete
    @DeleteMapping("/{cat_id}")
    public ResponseEntity<?> deleteACategory(@PathVariable Integer cat_id){
        this.cat_service.deleteCategory(cat_id);
        return new ResponseEntity<>("Deleted" , HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = this.cat_service.getAllCategories();

        return new ResponseEntity<>(categories , HttpStatus.OK);
    }
}