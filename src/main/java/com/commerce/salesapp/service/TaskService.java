package com.commerce.salesapp.service;

import com.commerce.salesapp.dto.TaskRequest;
import com.commerce.salesapp.dto.TaskResponse;
import com.commerce.salesapp.mapper.TaskMapper;
import com.commerce.salesapp.model.Task;
import com.commerce.salesapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskResponse> getAllTasks(){
        return taskMapper.toDtoList(taskRepository.findAll());
    }

    public TaskResponse createTask(TaskRequest request) {
        Task task = taskMapper.toEntity(request);
        Task savedtask = taskRepository.save(task);
        return taskMapper.toDto(savedtask);
    }

    public void deleteTask(Long id){
       if(taskRepository.existsById(id)){
           taskRepository.deleteById(id);
       }
       throw  new IllegalArgumentException("Task not found");
    }


}