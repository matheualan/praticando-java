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
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /insertProduct"));
        Product updateProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> findAll() {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /allProducts"));
        List<Product> findAll = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(findAll);
    }

    @PutMapping("/alterById/{id}")
    public ResponseEntity<Product> attProduct(@RequestBody Product product, @PathVariable Long id) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /alterById/{id}"));
        return productRepository.findById(id)
                .map(prod -> ResponseEntity.status(HttpStatus.OK).body(prod))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(product));
    }

}
