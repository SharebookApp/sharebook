package com.edu.eci.cosw.service;

import com.edu.eci.cosw.model.Usuario;
import com.edu.eci.cosw.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alejandro on 22/03/17.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Usuario getUserByEmail(String username) {
        return userRepository.findByEmail(username);
    }
}

