package com.example.demo.controllers;

import com.example.demo.baza.danych.Users;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@EnableMongoRepositories
@RestController
public class UserController {
    private final UsersRepository usersRepository;
//    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping(path = "/get")
    public List<Users> getUsers(){
        return usersRepository.findAll();
    }

    @PostMapping(path = "/get")
    public void getUsers(@RequestBody Users users){
//        String encodedPassword = passwordEncoder.encode(users.getPassword()); // Zakodowanie hasła za pomocą BCryptPasswordEncoder
//        users.setPassword(encodedPassword); // Ustawienie zakodowanego hasła na obiektu Users
        usersRepository.save(users); // Zapis do bazy danych
    }

//
//    @Bean
//    CommandLineRunner commandLineRunner(){
//        return args -> {
//            String encodedPassword = passwordEncoder.encode("ggg");
//            Users users= new Users(1L,"ggg",encodedPassword,"ADMIN");
//            usersRepository.save(users);
//        };
//    }

}
