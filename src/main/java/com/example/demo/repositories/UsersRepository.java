package com.example.demo.repositories;

import com.example.demo.baza.danych.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
}
