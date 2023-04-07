package com.example.demo.repositories;

import com.example.demo.baza.danych.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersReposiotry extends MongoRepository<Users,Long> {
}
