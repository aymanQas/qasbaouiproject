package com.example.qasbaouiproject.services.manager;

import com.example.qasbaouiproject.dao.entities.Client;
import com.example.qasbaouiproject.dao.entities.Product;

public interface ClientManager {
    Client registerClient(Client client);

    boolean addToCart(Client client, Product product);

    boolean removeFromCart(Client client, Product product);
}
