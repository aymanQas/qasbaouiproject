package com.example.qasbaouiproject.web;

import ch.qos.logback.core.model.Model;
import com.example.qasbaouiproject.dao.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {


    @GetMapping("/order")
    public String showOrderPage() {
        return "order";
    }
}
