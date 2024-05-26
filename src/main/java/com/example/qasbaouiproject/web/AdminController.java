package com.example.qasbaouiproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/homeadmin")
    public String adminHome() {
        return "homeadmin";
    }
}
