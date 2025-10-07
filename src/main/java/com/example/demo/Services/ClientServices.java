package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ClientRepository;
import com.example.demo.Model.Client;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    // Get all clients
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    // Get by Id
    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    // Save
    public Client save(Client client) {
        // Getters y Setters usan este patrón get + atributo
        if (client.getId() == null) {
            return clientRepository.save(client);

        } else {
            Optional<Client> clientOptional = getClient(client.getId());
            
            if (clientOptional.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    // Update
    public Client update(Client client) {
        if (client.getId() != null) {
            Optional<Client> clientToUpdate = getClient(client.getId());
            if (clientToUpdate.isPresent()) {
                
                if (client.getName() != null) {
                    clientToUpdate.get().setName(client.getName());
                }

                if (client.getName() != null) {
                    clientToUpdate.get().setPassword(client.getPassword());
                }

                clientRepository.save(clientToUpdate.get());
                return clientToUpdate.get();

            } else {
                return client;
            }

        } else {
            return client;
        }
    }

    // Delete
    public boolean deleteClient(int id) {
        boolean deletedStatus = false;
        Optional<Client> rowToDelete = clientRepository.getClient(id);

        if (rowToDelete.isPresent()) {
            clientRepository.delete(rowToDelete.get());
            deletedStatus = true;
        }

        return deletedStatus;
    }


}   

