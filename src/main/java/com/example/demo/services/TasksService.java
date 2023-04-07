package com.example.demo.services;

import com.example.demo.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TasksService {
    private final TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }
}
