package com.example.qasbaouiproject.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/Main")
    public String showOrderPage() {
        return "Main";
    }
}
