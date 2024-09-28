package com.example.clothing.repository;

import com.example.clothing.entities.Image;
import com.example.clothing.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>, PagingAndSortingRepository<Product, String> {

    @Query(value = """
            select * from product
            where (:categoryId is null or category_id = :categoryId)
            and (:color is null or color like CONCAT('%', :color, '%'))
            and (:size is null or size like CONCAT('%', :size, '%'))
            and (:style is null or style = :style)
            and (discount_price between :minPrice and :maxPrice)
            """, nativeQuery = true)
    Page<Product> getFilterProduct(String categoryId, String color, String size, String style, Double minPrice, Double maxPrice, Pageable pageable);
}
