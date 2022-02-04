package br.com.lojaonline.repository;

import br.com.lojaonline.model.Product;

import java.util.List;

public interface ProductServiceInterface {

    public Product createProduct(Product product);
    public List<Product> getProduct();
    public void deleteProduct(Long id);

}
