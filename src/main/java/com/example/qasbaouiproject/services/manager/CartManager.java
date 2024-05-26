package com.example.qasbaouiproject.services.manager;

import com.example.qasbaouiproject.dao.entities.Cart;
import com.example.qasbaouiproject.dao.entities.Product;

import java.util.List;

public interface CartManager {
    boolean addProductToCart(List<Cart> carts);

    boolean removeProductFromCart(Cart cart, Product product);

    //pour vider le panier
    void clearCart(Cart cart);
    void saveCart(Cart cart);

    double getTotalPrice(Cart cart);
    List<Cart> getAllCarts();

}
