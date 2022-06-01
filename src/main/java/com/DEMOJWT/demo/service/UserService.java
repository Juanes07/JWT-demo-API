package com.DEMOJWT.demo.service;

import com.DEMOJWT.demo.Entity.User;
import com.DEMOJWT.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service
 *
 * @author Juan Pablo Toro, Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User loadById(Long id) {

        return userRepository.findById(id).orElse(null);
    }
}
