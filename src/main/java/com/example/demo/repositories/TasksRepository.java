package com.example.demo.repositories;

import com.example.demo.baza.danych.Tasks;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TasksRepository extends MongoRepository<Tasks,Long> {
}
