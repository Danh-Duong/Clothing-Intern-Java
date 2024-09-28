package com.example.clothing.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    String id;

    String name;

    String description;

    Double price;

    Double discountPrice;

    String size;

    String color;

    String style;

    String brandName;

    int numStock;

    boolean status;

    String avatarUrl;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_image",
        joinColumns = @JoinColumn(name= "product_id"),
        inverseJoinColumns = @JoinColumn(name = "image_id"))
    List<Image> images;

}
