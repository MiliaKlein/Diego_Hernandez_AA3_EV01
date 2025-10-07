package com.example.demo.Repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Client;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {

}