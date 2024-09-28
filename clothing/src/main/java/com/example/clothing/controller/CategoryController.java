package com.example.clothing.controller;

import com.example.clothing.entities.Category;
import com.example.clothing.payload.response.ApiResponse;
import com.example.clothing.payload.response.ProductResponse;
import com.example.clothing.payload.response.ResponseCode;
import com.example.clothing.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getCategories(){
        List<Category> categories = categoryService.getCategories();
        if (categories.size()==0)
            return ResponseEntity.ok(ApiResponse.response(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND.getMessage()));
        return ResponseEntity.ok(ApiResponse.response(2000,categories));
    }
}
