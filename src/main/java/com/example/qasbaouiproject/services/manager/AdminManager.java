package com.example.qasbaouiproject.services.manager;

import com.example.qasbaouiproject.dao.entities.Order;
import com.example.qasbaouiproject.dao.entities.Product;

public interface AdminManager {
    boolean deleteOrder(Long orderId);


    boolean updateOrder(Order updatedOrder);

    Product addProduct(Product product);

    boolean deleteProduct(Long productId);

    boolean updateProduct(Product updatedProduct);
}
