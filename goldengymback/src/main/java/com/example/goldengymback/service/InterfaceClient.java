package com.example.goldengymback.service;

import com.example.goldengymback.model.client;
import java.util.Optional;

public interface InterfaceClient {

    // Méthode pour ajouter un client
    public client ajouterClient(client nouvclient);

    // Méthode pour récupérer un client par son ID
    public Optional<client> getClientById(long id);

    // Méthode pour trouver un client par son nom et mot de passe
    public boolean findByNameAndPassword(String name, String password);
}
