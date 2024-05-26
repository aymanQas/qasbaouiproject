package com.example.qasbaouiproject.services.service;

import com.example.qasbaouiproject.dao.entities.Product;
import com.example.qasbaouiproject.dao.repositories.ProductRepository;
import com.example.qasbaouiproject.services.manager.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductManager {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {

        try{
            return  productRepository.save(product);
        }catch (Exception exception){
            System.out.println(exception.getMessage()); //Logger
            return null;
        }
    }
    @Override
   public boolean deleteProduct(Product product) {
  return false;
   }
    @Override
    public boolean deleteProductById(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(Long.valueOf(id)).get();
    }
    @Override
    public Page<Product> getAllProduits(int page, int taille) {
        return productRepository.findAll(PageRequest.of(page, taille));
    }

    public Page<Product> searchProducts(String keyword, int page, int size) {
        // Utilisez le repository pour rechercher les produits en fonction du mot-clé
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword, pageable);
    }
}
