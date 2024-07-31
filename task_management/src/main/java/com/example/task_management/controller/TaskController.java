package com.example.task_management.controller;

import com.example.task_management.Service.TaskService;
import com.example.task_management.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/getAllTask")
    private List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @GetMapping("/getTask/{id}")
    private Task getTask(@PathVariable("id") int id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/deleteTask/{id}")
    private void deleteTask(@PathVariable("id") int id) {
        taskService.deleteTaskById(id);
    }

    @PostMapping("/addTask")
    private Task addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return task;
    }

    @PutMapping("/updateTask/{id}")
    private Task updateTask(@RequestBody Task task, @PathVariable("id") int id) {
        Task existingTask = taskService.getTaskById(id);
        taskService.updateTask(task, id);
        return existingTask;
    }

    @GetMapping("/searchByName")
    private List<Task> searchByName(@RequestParam("title") String title) {
        return taskService.searchByName(title);
    }
}
