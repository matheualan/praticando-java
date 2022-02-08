package br.com.lojaonline.controller;

import br.com.lojaonline.model.Item;
import br.com.lojaonline.repository.ItemRepository;
import br.com.lojaonline.service.ItemService;
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
@RequestMapping("/item")
//@Log4j2
public class ItemController {

    private static final Logger logger = LogManager.getLogger(ItemController.class);

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemService itemService;
    @Autowired
    private DateUtil dateUtil;

    @GetMapping(path = "/listeTudo")
    public ResponseEntity<List<Item>> listeTudo() {
        itemService.getProduct();
        return new ResponseEntity<List<Item>>(HttpStatus.OK);
    }

    @PostMapping("/criarProduto")
    public ResponseEntity<Item> criandoProduto(@RequestBody Item item) {
        Item novoProduto = itemService.createProduct(item);
        return new ResponseEntity<Item>(HttpStatus.CREATED);
    }

    @PostMapping("/insertItem")
    public ResponseEntity<Item> insertProduct(@RequestBody Item item) {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /insertProduct"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /insertProduct"));
        Item updateItem = itemRepository.save(item);
        return ResponseEntity.status(HttpStatus.OK).body(updateItem);
//        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @GetMapping("/allItems")
    public ResponseEntity<List<Item>> findAllProducts() {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /allProducts"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /allProducts"));
        List<Item> findAll = itemRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(findAll);
//        return new ResponseEntity<List<Product>>(HttpStatus.OK);
    }

    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<Optional<Item>> findById(@PathVariable Long id) {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /findById"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /findById"));
        try {
            Optional<Item> findId = itemRepository.findById(id);
            return ResponseEntity.ok().body(findId);
//            return new ResponseEntity<Optional<Product>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Item> updateProductById(@PathVariable Long id, @RequestBody Item newItem) {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /updateById"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /updateById/{id}"));
        return itemRepository.findById(id)
                .map(itemChanged -> {
                    itemChanged.setName(newItem.getName());
                    itemChanged.setPrice(newItem.getPrice());
                    itemChanged.setDate(newItem.getDate());
                    Item itemUpdated = itemRepository.save(itemChanged);
                    return ResponseEntity.ok().body(itemUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<Optional<Item>> deleteById(@PathVariable Long id) {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /deleteById"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /deleteById"));
        try {
            itemRepository.deleteById(id);
            return new ResponseEntity<Optional<Item>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Item>>(HttpStatus.NOT_FOUND);
        }
    }

}
