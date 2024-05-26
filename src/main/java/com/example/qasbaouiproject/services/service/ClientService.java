package com.example.qasbaouiproject.services.service;

import com.example.qasbaouiproject.dao.entities.Cart;
import com.example.qasbaouiproject.dao.entities.Client;
import com.example.qasbaouiproject.dao.entities.Product;
import com.example.qasbaouiproject.dao.repositories.ClientRepository;
import com.example.qasbaouiproject.services.manager.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientManager {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client registerClient(Client client) {
        if (clientRepository.existsByUsername(client.getUsername())) {
            return null; // Client déjà enregistré
        }
        return clientRepository.save(client);
    }
    @Override
    public boolean addToCart(Client client, Product product) {
        // Récupérer le panier du client
        Cart cart = client.getCart();
        if (cart == null) {
            return false; // Panier non trouvé
        }
        return  cart.addProduct(product);
    }
    @Override
    public boolean removeFromCart(Client client, Product product) {
        // Récupérer le panier du client
        Cart cart = client.getCart();
        if (cart == null) {
            return false; // Panier non trouvé
        }
        return cart.removeProduct(product);
    }

}
