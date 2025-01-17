package com.example.Blogging.Application.repositories;

import com.example.Blogging.Application.entities.Category;
import com.example.Blogging.Application.payloads.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
