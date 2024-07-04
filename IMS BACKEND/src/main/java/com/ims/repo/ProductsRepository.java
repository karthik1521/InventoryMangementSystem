package com.ims.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
