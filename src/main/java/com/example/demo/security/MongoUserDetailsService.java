package com.example.demo.security;

import com.example.demo.baza.danych.Users;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MongoUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public MongoUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String name = String.valueOf(usersRepository.findByUsername(username));
        System.out.println(name);
        return usersRepository.findByUsername(username)
                .map(UsersSecurity::new)
                .orElseThrow(() -> new UsernameNotFoundException("NOt FOUND"));
    }

}