package com.example.goldengymback.controller;


import com.example.goldengymback.model.client;
import com.example.goldengymback.serviceImpl.ServImpClient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {
    @Autowired
    ServImpClient serv;

    @PostMapping("/AddClient")
    public client addClient(@RequestBody client nouvclient){
        return  serv.ajouterClient(nouvclient);
    }
    @PutMapping("/UpdateClient/{id}")
    public ResponseEntity<client> updateClient(@PathVariable long id, @Valid @RequestBody client updatedClient) {
        return serv.getClientById(id)
                .map(client -> {
                    client.setName(updatedClient.getName());
                    client.setEmail(updatedClient.getEmail());
                    client.setPassword(updatedClient.getPassword());
                    client.setPhotoUrl(updatedClient.getPhotoUrl());
                    client savedClient = serv.ajouterClient(client);
                    return ResponseEntity.ok(savedClient);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/trouvClient")
    public boolean trouvClient(@RequestBody client cliente) {
        return serv.findByNameAndPassword(cliente.getName(),cliente.getPassword());
    }




}
