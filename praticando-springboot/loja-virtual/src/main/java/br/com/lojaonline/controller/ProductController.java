package br.com.lojaonline.controller;

import br.com.lojaonline.model.Product;
import br.com.lojaonline.repository.ProductRepository;
import br.com.lojaonline.service.ProductService;
import br.com.lojaonline.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
//@Log4j2
public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private DateUtil dateUtil;

    @GetMapping(path = "/listeTudo")
    public ResponseEntity<List<Product>> listeTudo() {
        productService.getProduct();
        return new ResponseEntity<List<Product>>(HttpStatus.OK);
    }

    @PostMapping("/criarProduto")
    public ResponseEntity<Product> criandoProduto(@RequestBody Product product) {
        Product novoProduto = productService.createProduct(product);
        return new ResponseEntity<Product>(HttpStatus.CREATED);
    }

    @PostMapping("/insertProduct")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        logger.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /insertProduct"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /insertProduct"));
        Product updateProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
//        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> findAllProducts() {
        logger.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /allProducts"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /allProducts"));
        List<Product> findAll = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(findAll);
//        return new ResponseEntity<List<Product>>(HttpStatus.OK);
    }

    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        logger.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /findById"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /findById"));
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
        logger.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /updateById"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /updateById/{id}"));
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
        logger.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /deleteById"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /deleteById"));
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<Optional<Product>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Product>>(HttpStatus.NOT_FOUND);
        }
    }

}
