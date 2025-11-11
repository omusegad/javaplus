package com.commerce.salesapp.service;

import com.commerce.salesapp.dto.UserRequest;
import com.commerce.salesapp.model.User;
import com.commerce.salesapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

   private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void deleteById( long id){
        userRepository.deleteById(id);
    }

}