package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;     

@Getter
@Setter
@Entity
@Table(name = "users")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name",  nullable = false, length = 10)
    private String name;
    
    @Column(name = "password",  nullable = false, length = 10)
    private String password;
    
}
