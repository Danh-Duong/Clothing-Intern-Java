package com.example.clothing.service.serviceImp;

import com.example.clothing.entities.Category;
import com.example.clothing.repository.CategoryRepository;
import com.example.clothing.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
