package com.validation.exception.demo.service;

import com.validation.exception.demo.dto.UserRequest;
import com.validation.exception.demo.entity.User;
import com.validation.exception.demo.exception.UserNotFoundException;
import com.validation.exception.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest){

        User user=User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .address(userRequest.getAddress()).build();
       return userRepository.save(user);
    }
    public List<User> getAllUser(){

        return userRepository.findAll();
    }

    public User getUserById(long id){
        User user= userRepository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("User not found with id : "+id);
        }

    }
}
