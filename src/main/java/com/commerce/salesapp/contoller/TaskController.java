package com.commerce.salesapp.contoller;

import com.commerce.salesapp.dto.TaskRequest;
import com.commerce.salesapp.dto.TaskResponse;
import com.commerce.salesapp.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks(){
        List<TaskResponse> tasks = taskService.getAllTasks();
        if(tasks.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody @Valid TaskRequest taskRequest){
       TaskResponse response = taskService.createTask(taskRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return  ResponseEntity.noContent().build();
    }


}