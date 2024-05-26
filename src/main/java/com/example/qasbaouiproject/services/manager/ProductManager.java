package com.example.qasbaouiproject.services.manager;

import com.example.qasbaouiproject.dao.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductManager {
    Product addProduct(Product product);

    boolean deleteProduct(Product product);

    boolean deleteProductById(Long id);

    Product updateProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(Long id);

    Page<Product> getAllProduits(int page, int taille);

}
