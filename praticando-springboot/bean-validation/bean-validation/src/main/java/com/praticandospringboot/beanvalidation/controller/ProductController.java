package com.praticandospringboot.beanvalidation.controller;

import com.praticandospringboot.beanvalidation.model.Product;
import com.praticandospringboot.beanvalidation.repository.ProductRepository;
import com.praticandospringboot.beanvalidation.utils.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@Log4j2
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DateUtil dateUtil;

    @GetMapping("/getProduct")
    public String retorneAlgo() {
        return "TESTANDO API";
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> listAllProducts = new ArrayList<>();
        listAllProducts = productRepository.findAll();
        return new ResponseEntity<>(listAllProducts, HttpStatus.OK);
    }

}
