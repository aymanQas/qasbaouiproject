package com.example.qasbaouiproject.services.service;

import com.example.qasbaouiproject.dao.entities.Utilisateur;
import com.example.qasbaouiproject.dao.repositories.UtilisateurRepository;
import com.example.qasbaouiproject.services.manager.UtilisateurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurManagerMetier implements UtilisateurManager {

    @Autowired
    private UtilisateurRepository user;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public Integer IsValidUser(String email, String password) {
        return user.getUtilisateurByEmailAndAndMotDePasse(email,password).getId();
    }

    @Override
    public void register(Utilisateur new_user) {
        user.save(new_user);
    }



    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Integer id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Integer id) {
        utilisateurRepository.deleteById(id);
    }
}

