package br.com.lojaonline.controller;

import br.com.lojaonline.dto.ItemDTO;
import br.com.lojaonline.model.ItemModel;
import br.com.lojaonline.repository.ItemRepository;
import br.com.lojaonline.service.ItemService;
import br.com.lojaonline.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/item")
//@Log4j2
public class ItemController {

    private static final Logger logger = LogManager.getLogger(ItemController.class);

    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final DateUtil dateUtil;

    public ItemController(ItemRepository itemRepository, ItemService itemService, DateUtil dateUtil) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
        this.dateUtil = dateUtil;
    }

    @GetMapping(path = "/listeTudo")
    public ResponseEntity<List<ItemModel>> listeTudo() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAllProducts());
    }

    @PostMapping("/criarProduto")
    public ResponseEntity<ItemModel> criandoProduto(@RequestBody ItemDTO itemDTO) {
        var itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDTO, itemModel);
        itemModel.setRegistrationDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createProduct(itemModel));
    }

    @PostMapping("/insertItem")
    public ResponseEntity<ItemModel> insertProduct(@RequestBody ItemDTO itemDTO) {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /insertProduct"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /insertProduct"));
        var itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDTO, itemModel);
        itemModel.setRegistrationDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(itemRepository.save(itemModel));
//        ItemModel itemModel = itemRepository.save(itemDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(itemModel);
//        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @GetMapping("/allItems")
    public ResponseEntity<List<ItemModel>> findAllProducts() {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /allProducts"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /allProducts"));
        List<ItemModel> findAll = itemRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(findAll);
//        return new ResponseEntity<List<Product>>(HttpStatus.OK);
    }

    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<Optional<ItemModel>> findById(@PathVariable UUID id) {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /findById"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /findById"));
        try {
            Optional<ItemModel> findId = itemRepository.findById(id);
            return ResponseEntity.ok().body(findId);
//            return new ResponseEntity<Optional<Product>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<ItemModel> updateProductById(@PathVariable UUID id, @RequestBody ItemModel newItemModel) {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /updateById"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /updateById/{id}"));
        return itemRepository.findById(id)
                .map(itemModelChanged -> {
                    itemModelChanged.setName(newItemModel.getName());
                    itemModelChanged.setPrice(newItemModel.getPrice());
                    itemModelChanged.setRegistrationDate(newItemModel.getRegistrationDate());
                    ItemModel itemModelUpdated = itemRepository.save(itemModelChanged);
                    return ResponseEntity.ok().body(itemModelUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<Optional<ItemModel>> deleteById(@PathVariable UUID id) {
        logger.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /deleteById"));
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /deleteById"));
        try {
            itemRepository.deleteById(id);
            return new ResponseEntity<Optional<ItemModel>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<ItemModel>>(HttpStatus.NOT_FOUND);
        }
    }

}
