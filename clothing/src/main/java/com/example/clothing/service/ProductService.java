package com.example.clothing.service;

import com.example.clothing.payload.response.ProductDetailResponse;
import com.example.clothing.payload.response.ProductResponse;

import java.util.List;

public interface ProductService {

    public List<ProductResponse> getFilterProduct(String categoryId,
                                                  String color,
                                                  String size,
                                                  String style,
                                                  Double minPrice,
                                                  Double maxPrice,
                                                  int pageSize);

    public ProductDetailResponse getProductById(String id);
}
