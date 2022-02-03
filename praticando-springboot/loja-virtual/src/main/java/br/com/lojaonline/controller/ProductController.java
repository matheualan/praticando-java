package br.com.lojaonline.controller;

import br.com.lojaonline.model.Product;
import br.com.lojaonline.repository.ProductRepository;
import br.com.lojaonline.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@Log4j2
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DateUtil dateUtil;

    @PostMapping("/insertProduct")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /insertProduct"));
        Product updateProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> findAllProducts() {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /allProducts"));
        List<Product> findAll = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(findAll);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long id, @RequestBody Product newProduct) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /updateById/{id}"));
        return productRepository.findById(id)
                .map(productChanged -> {
                    productChanged.setName(newProduct.getName());
                    productChanged.setPrice(newProduct.getPrice());
                    productChanged.setDate(newProduct.getDate());
                    Product productUpdated = productRepository.save(productChanged);
                    return ResponseEntity.ok().body(productUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

}
