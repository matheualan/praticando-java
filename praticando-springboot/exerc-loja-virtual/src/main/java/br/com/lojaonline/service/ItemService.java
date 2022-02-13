package br.com.lojaonline.service;

import br.com.lojaonline.model.ItemModel;
import br.com.lojaonline.repository.ItemRepository;
import br.com.lojaonline.repository.ItemServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService implements ItemServiceInterface {

    final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    @Override
    public ItemModel createProduct(ItemModel itemModel) {
        return itemRepository.save(itemModel);
    }

    @Override
    public void getById(UUID id) {
        itemRepository.findById(id);
    }

    @Override
    public List<ItemModel> getAllProducts() {
        return itemRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteProduct(UUID id) {
        itemRepository.deleteById(id);
    }

}
