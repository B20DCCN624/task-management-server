package com.example.task_management.Service;

import com.example.task_management.model.Task;
import com.example.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAllTask() {
        List<Task> task = new ArrayList<Task>();
        taskRepository.findAll().forEach(task::add);
        return task;
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).get();
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }
    public void updateTask(Task task, int id) {
        task.setId(id);
        taskRepository.save(task);
    }

    public void deleteTaskById(int id) {
        taskRepository.deleteById(id);
    }
}
