package com.example.qasbaouiproject.services.service;

import com.example.qasbaouiproject.dao.entities.Order;
import com.example.qasbaouiproject.dao.entities.Product;
import com.example.qasbaouiproject.dao.repositories.OrderRepository;
import com.example.qasbaouiproject.dao.repositories.ProductRepository;
import com.example.qasbaouiproject.services.manager.AdminManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService implements AdminManager {


    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public AdminService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            orderRepository.delete(order);
            return true;
        }
        return false;
    }
    @Override
    public boolean updateOrder(Order updatedOrder) {
        boolean isUpdated = false;
        Optional<Order> optionalExistingOrder = orderRepository.findById((long) updatedOrder.getId());
        if (optionalExistingOrder.isPresent()) {
            Order existingOrder = optionalExistingOrder.get();
            existingOrder.setClient(updatedOrder.getClient());
            existingOrder.getProducts().clear();
            existingOrder.getProducts().addAll(updatedOrder.getProducts());
            existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
            orderRepository.save(existingOrder);
            isUpdated = true;
        }
        return isUpdated;
    }
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public boolean deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            productRepository.delete(product);
            return true;
        }
        return false;
    }
@Override
    public boolean updateProduct(Product updatedProduct) {
        Product existingProduct = productRepository.findById(Long.valueOf(updatedProduct.getId())).orElse(null);
        if (existingProduct != null) {
            // Mettre à jour les attributs du produit existant
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            // Enregistrer les modifications
            productRepository.save(existingProduct);
            return true;
        }
        return false;
    }

}
