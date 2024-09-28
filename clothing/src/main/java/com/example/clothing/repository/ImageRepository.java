package com.example.clothing.repository;

import com.example.clothing.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query("SELECT i FROM Image i JOIN i.products p WHERE p.id = :productId")
    List<Image> findImagesByProductId(String productId);
}
