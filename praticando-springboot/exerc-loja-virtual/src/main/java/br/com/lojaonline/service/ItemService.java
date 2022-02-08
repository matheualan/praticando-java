package br.com.lojaonline.service;

import br.com.lojaonline.model.Item;
import br.com.lojaonline.repository.ItemRepository;
import br.com.lojaonline.repository.ItemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements ItemServiceInterface {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item createProduct(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getProduct() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        itemRepository.deleteById(id);
    }

}
