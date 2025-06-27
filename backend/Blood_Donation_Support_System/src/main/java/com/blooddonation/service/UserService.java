//Xử lý logic người dùng
package com.blooddonation.service;

import com.blooddonation.model.User;
import com.blooddonation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

}
