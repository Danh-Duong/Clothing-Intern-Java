package com.example.clothing.controller;

import com.example.clothing.payload.response.ApiResponse;
import com.example.clothing.payload.response.ProductDetailResponse;
import com.example.clothing.payload.response.ProductResponse;
import com.example.clothing.payload.response.ResponseCode;
import com.example.clothing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getFiterProduct(
            @RequestParam(required = false, defaultValue = "12") int pageSize,
            @RequestParam(required = false) String categoryId,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String style,
            @RequestParam(required = false, defaultValue = "30") Double minPrice,
            @RequestParam(required = false, defaultValue = "3000") Double maxPrice){

        List<ProductResponse> products = productService.getFilterProduct(categoryId,color,size,style,minPrice,maxPrice,pageSize);

        if (products.size()==0)
            return ResponseEntity.ok(ApiResponse.response(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND.getMessage()));
        return ResponseEntity.ok(ApiResponse.response(2000,products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id){
        ProductDetailResponse product = productService.getProductById(id);
        if (product==null)
            return ResponseEntity.ok(ApiResponse.response(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND.getMessage()));
        return ResponseEntity.ok(ApiResponse.response(2000,product));
    }
}


