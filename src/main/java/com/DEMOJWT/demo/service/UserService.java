package com.DEMOJWT.demo.service;

import com.DEMOJWT.demo.Entity.User;
import com.DEMOJWT.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //cargar usuario
    public User loadUserbyUser(String username) {
        User userName = userRepository.findByUserName(username);
        return userName;
    }


}
