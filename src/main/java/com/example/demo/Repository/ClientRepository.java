package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Repository.CrudRepository.ClientCrudRepository;
import com.example.demo.Model.Client;

@Repository
public class ClientRepository  {

    @Autowired
    private ClientCrudRepository clientCrudRepository;
    

    // Get
    public List<Client> findAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    // Get by Id
    public Optional<Client> getClient(int id) {
        return clientCrudRepository.findById(id);
    }

    // Save
    public Client save(Client client) {
        return clientCrudRepository.save(client);
    }

    // Delete
    public void delete(Client client) {
        clientCrudRepository.delete(client);
    }
}
