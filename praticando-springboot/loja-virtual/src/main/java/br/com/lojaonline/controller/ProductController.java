package br.com.lojaonline.controller;

import br.com.lojaonline.model.Product;
import br.com.lojaonline.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/insertProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updateProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> findAll = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(findAll);
    }

    @PutMapping("/alterById/{id}")
    public ResponseEntity<Product> attProduct(@RequestBody Product product, @PathVariable Long id) {
        return productRepository.findById(id)
                .map(prod -> ResponseEntity.status(HttpStatus.OK).body(prod))
    }

}
