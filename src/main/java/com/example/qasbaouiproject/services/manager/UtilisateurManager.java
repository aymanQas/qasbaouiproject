package com.example.qasbaouiproject.services.manager;

import com.example.qasbaouiproject.dao.entities.Utilisateur;

public interface UtilisateurManager {

    Integer IsValidUser(String email, String password);

    void register(Utilisateur new_user);
}
