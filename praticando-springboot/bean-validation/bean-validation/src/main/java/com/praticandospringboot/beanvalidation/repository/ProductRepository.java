package com.praticandospringboot.beanvalidation.repository;

import com.praticandospringboot.beanvalidation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
