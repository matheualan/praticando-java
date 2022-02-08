package br.com.lojaonline.repository;

import br.com.lojaonline.model.Item;

import java.util.List;

public interface ItemServiceInterface {

    public Item createProduct(Item item);
    public List<Item> getProduct();
    public void deleteProduct(Long id);

}
