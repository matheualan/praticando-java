package br.com.lojaonline.repository;

import br.com.lojaonline.model.ItemModel;

import java.util.List;
import java.util.UUID;

public interface ItemServiceInterface {

    ItemModel createProduct(ItemModel itemModel);
    List<ItemModel> getAllProducts();
    void getById(UUID id);
    void deleteProduct(UUID id);

}
