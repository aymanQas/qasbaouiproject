package com.example.qasbaouiproject.web;

import org.springframework.ui.Model;


import com.example.qasbaouiproject.dao.entities.Cart;
import com.example.qasbaouiproject.services.service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping("/add_cart")
    private String addCart(@RequestParam("carts") String carts) throws JsonProcessingException {
        System.out.println(carts);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Cart> cart_ = objectMapper.readValue(carts, new TypeReference<List<Cart>>() {});

        // Process the list of products
        for (Cart c : cart_) {
            Date currentDate = new Date();
            Cart cart = new Cart(null, c.getTitle(), c.getTotalPrice(), currentDate, null, null);
            cart.setDateCmd(currentDate);
            cartService.saveCart(cart);
        }

        return "redirect:/order";
    }
    @GetMapping("/indexcart")
    public String indexCart(Model model) {
        List<Cart> cartList = cartService.getAllCarts();
        model.addAttribute("cartList", cartList);
        return "indexcart";
    }
    @GetMapping("/editCart")
    public String editCart(@RequestParam("id") Long id, Model model) {
        Cart cart = cartService.getCartById(id);
        if (cart != null) {
            model.addAttribute("cart", cart);
            return "editCart";
        } else {
            return "error";
        }
    }

    @PostMapping("/updateCart")
    public String updateCart(@ModelAttribute("cart") Cart cart) {
        cartService.saveCart(cart);
        return "redirect:/indexcart";
    }

    @GetMapping("/deleteCart")
    public String deleteCart(@RequestParam("id") Long id) {
        cartService.deleteCartById(id);
        return "redirect:/indexcart";
    }
}


