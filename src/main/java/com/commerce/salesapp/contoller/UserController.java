package com.commerce.salesapp.contoller;

import com.commerce.salesapp.dto.UserRequest;
import com.commerce.salesapp.model.User;
import com.commerce.salesapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);

    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email){
      User user = userService.getUserByEmail(email);
      if(user == null){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> createUser( @Valid @RequestBody User user){
       userService.createUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}