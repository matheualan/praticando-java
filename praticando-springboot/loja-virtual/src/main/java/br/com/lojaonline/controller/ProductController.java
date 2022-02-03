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
import java.util.NoSuchElementException;
import java.util.Optional;

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
//        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> findAllProducts() {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /allProducts"));
        List<Product> findAll = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(findAll);
//        return new ResponseEntity<List<Product>>(HttpStatus.OK);
    }

    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /findById"));
        try {
            Optional<Product> findId = productRepository.findById(id);
            return ResponseEntity.ok().body(findId);
//            return new ResponseEntity<Optional<Product>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return ResponseEntity.notFound().build();
        }
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

    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<Optional<Product>> deleteById(@PathVariable Long id) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /deleteById"));
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<Optional<Product>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Product>>(HttpStatus.NOT_FOUND);
        }
    }

}
