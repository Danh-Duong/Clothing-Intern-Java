package com.example.clothing.service.serviceImp;

import com.example.clothing.entities.Image;
import com.example.clothing.entities.Product;
import com.example.clothing.payload.response.ProductDetailResponse;
import com.example.clothing.payload.response.ProductResponse;
import com.example.clothing.repository.ImageRepository;
import com.example.clothing.repository.ProductRepository;
import com.example.clothing.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiveImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductResponse> getFilterProduct(String categoryId, String color, String size, String style, Double minPrice, Double maxPrice, int pageSize) {

        Pageable pageable = PageRequest.of(0, pageSize, Sort.by("name").ascending());

        Page<Product> products = productRepository.getFilterProduct(categoryId,color,size,style,minPrice, maxPrice,pageable);

        List<ProductResponse> result = products.stream().map(prod -> modelMapper.map(prod, ProductResponse.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public ProductDetailResponse getProductById(String id) {

        Optional<Product> product = productRepository.findById(id);
        ProductDetailResponse response = null;

        if (product.isPresent()){

            List<Image> images = imageRepository.findImagesByProductId(product.get().getId());
            response = modelMapper.map(product, ProductDetailResponse.class);
            response.setSize(List.of(product.get().getSize().split(",")));
            response.setColor(List.of(product.get().getColor().split(",")));
            response.setImgUrls(images.stream().map(i -> i.getImgUrl()).collect(Collectors.toList()));
        }

        return response;

    }
}
