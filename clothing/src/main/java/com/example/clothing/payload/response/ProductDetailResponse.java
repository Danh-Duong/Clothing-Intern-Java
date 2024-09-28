package com.example.clothing.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailResponse {
    String id;

    String name;

    String description;

    Double price;

    Double discountPrice;

    List<String> size;

    List<String> color;

    String style;

    String brandName;

    List<String> imgUrls;
}
