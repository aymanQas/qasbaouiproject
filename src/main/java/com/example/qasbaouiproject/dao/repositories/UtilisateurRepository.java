package com.example.qasbaouiproject.dao.repositories;

import com.example.qasbaouiproject.dao.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    public Utilisateur getUtilisateurByEmailAndAndMotDePasse(String email,String password);
}
