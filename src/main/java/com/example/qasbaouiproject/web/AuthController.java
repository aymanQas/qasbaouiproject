package com.example.qasbaouiproject.web;
import org.springframework.ui.Model;

import com.example.qasbaouiproject.dao.entities.Utilisateur;
import com.example.qasbaouiproject.services.service.UtilisateurManagerMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UtilisateurManagerMetier user;
    @Autowired
    private UtilisateurManagerMetier utilisateurManagerMetier;

    @GetMapping(path = "/login")
    public String Login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        if ("admin@gmail.com".equals(email) && "12345".equals(password)) {
            return "redirect:/index";
        } else {
            Integer userId = user.IsValidUser(email, password);
            if (userId != null) {
                return "redirect:/Main";
            } else {
                redirectAttributes.addFlashAttribute("error", "L'email ou le mot de passe est incorrect");
                return "redirect:/login";
            }
        }
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("register")
    public String register(@ModelAttribute("Utilisateur") Utilisateur new_user) {
        user.register(new_user);
        return "redirect:/login";
    }
    @GetMapping("/indexclient")
    public String listeClients(Model model) {
        List<Utilisateur> listeUtilisateurs = utilisateurManagerMetier.getAllUtilisateurs();
        model.addAttribute("utilisateurs", listeUtilisateurs);
        return "indexclient";
    }


    @GetMapping("/ajouterUser")
    public String ajouterUserForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "ajouterUser";
    }

    @PostMapping("/addUser")
    public String ajouterUser(@ModelAttribute Utilisateur utilisateur) {
        utilisateurManagerMetier.register(utilisateur);
        return "redirect:/indexclient";
    }

    @GetMapping("/editUser/{id}")
    public String editUserForm(@PathVariable Integer id, Model model) {
        Optional<Utilisateur> utilisateur = utilisateurManagerMetier.getUtilisateurById(id);
        if (utilisateur.isPresent()) {
            model.addAttribute("utilisateur", utilisateur.get());
            return "editUser";
        } else {
            return "redirect:/indexclient";
        }
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute Utilisateur utilisateur) {
        utilisateurManagerMetier.updateUtilisateur(utilisateur);
        return "redirect:/indexclient";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        utilisateurManagerMetier.deleteUtilisateur(id);
        return "redirect:/indexclient";
    }
}