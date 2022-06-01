package com.DEMOJWT.demo.service;

import com.DEMOJWT.demo.Entity.User;
import com.DEMOJWT.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User loadById(Long id){

        return userRepository.findById(id).orElse(null);
    }

//    cargar usuario
//    public User loadUserbyUser(Long id) {
//        User userName = userRepository.findById(id);
//        return userName;
//    }


}
