package com.example.demo.services;

import com.example.demo.repositories.UsersReposiotry;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersService {
    private final UsersReposiotry usersReposiotry;

    @Autowired
    public UsersService(UsersReposiotry usersReposiotry) {
        this.usersReposiotry = usersReposiotry;
    }
}
