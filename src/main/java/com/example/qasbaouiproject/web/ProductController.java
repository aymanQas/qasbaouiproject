package com.example.qasbaouiproject.web;

import com.example.qasbaouiproject.dao.entities.Product;
import com.example.qasbaouiproject.services.manager.ProductManager;
import com.example.qasbaouiproject.services.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    @Autowired
    private ProductManager productManager;
    @Autowired
    private ProductService productService;


    @GetMapping("/deleteProduit")
    public String deleteProduitAction(@RequestParam(name = "id") Long id) {
        if (productManager.deleteProductById(id)) {
            return "redirect:/index";
        } else {
            return "error";
        }
    }
    @GetMapping("/editProduit")
    public String editProduitAction(Model model, @RequestParam(name = "id") Long id) {
        Product produit = productManager.getProductById(id);
        if (produit != null) {
            model.addAttribute("produitToBeUpdated", produit);
            return "form";
        } else {
            return "error";
        }
    }
    @PostMapping("/save")
    public String update(Product p) {
        productManager.addProduct(p);
        return "redirect:/index";
    }

    @GetMapping("/addproduct")
    public String addProductAction(Model model) {
        model.addAttribute("newProduct", new Product());
        return "formAddPro";
    }

    @PostMapping("/ajouter-produit")
    public String addProduct(@ModelAttribute("newProduct") Product newProduct) {
        productManager.addProduct(newProduct);
        return "redirect:/index";
    }


    @GetMapping("/index")
    public String listProduitsAction(Model model,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "taille", defaultValue = "6") int taille,
                                     @RequestParam(name = "search", required = false) String search) {

        Page<Product> produits;

        if (search != null && !search.isEmpty()) {

            produits = productService.searchProducts(search, page, taille);
        } else {

            produits = productManager.getAllProduits(page, taille);
        }

        model.addAttribute("listProduits", produits.getContent());
        int totalPages = produits.getTotalPages();
        model.addAttribute("totalPages", totalPages);

        List<Integer> pages = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
        model.addAttribute("pages", pages);

        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", search);

        return "index";
    }


}
