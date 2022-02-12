package br.com.lojaonline.repository;

import br.com.lojaonline.model.ItemModel;

import java.util.List;
import java.util.UUID;

public interface ItemServiceInterface {

    public ItemModel createProduct(ItemModel itemModel);
    public List<ItemModel> getAllProducts();
    public void deleteProduct(UUID id);

}
