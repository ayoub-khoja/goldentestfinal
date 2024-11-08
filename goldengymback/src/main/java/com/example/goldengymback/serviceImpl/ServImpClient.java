package com.example.goldengymback.serviceImpl;

import ch.qos.logback.core.net.server.Client;
import com.example.goldengymback.model.client;
import com.example.goldengymback.repository.ClientRepo;
import com.example.goldengymback.service.InterfaceClient;
import com.sun.jdi.connect.Connector;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
public class ServImpClient implements InterfaceClient {

    @Autowired
    ClientRepo repo;
    @Override
    public client ajouterClient(client nouvclient) {
        return repo.save(nouvclient);
    }
    @Override
    public Optional<client> getClientById(long id) {
        return repo.findById(id);
    }

    @Override
    public boolean findByNameAndPassword(String name, String password) {
        return repo.findByNameAndPassword(name, password);
    }


}
