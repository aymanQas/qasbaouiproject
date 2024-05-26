package com.example.qasbaouiproject.services.service;

import com.example.qasbaouiproject.dao.entities.Cart;
import com.example.qasbaouiproject.dao.entities.Product;
import com.example.qasbaouiproject.dao.repositories.CartRepository;
import com.example.qasbaouiproject.services.manager.CartManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CartService implements CartManager {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public boolean addProductToCart(@RequestBody List<Cart> carts) {

        cartRepository.saveAll(carts);

        return true;
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }
    @Override
    public boolean removeProductFromCart(Cart cart, Product product) {
        // Supprime le produit du panier
        boolean removed = cart.getProducts().remove(product);
        if (removed) {
            cartRepository.save(cart);
        }
        return removed;
    }
    //pour vider le panier
    @Override
    public void clearCart(Cart cart) {
        cart.getProducts().clear();
        cartRepository.save(cart);
    }
    @Override
    public double getTotalPrice(Cart cart) {
        double totalPrice = 0.0;
        for (Product product : cart.getProducts()) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }



    public void deleteCartById(Long id) {
        cartRepository.deleteById(id);
    }
}
