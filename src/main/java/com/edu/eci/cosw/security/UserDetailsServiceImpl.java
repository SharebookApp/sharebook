package com.edu.eci.cosw.security;

import com.edu.eci.cosw.model.CurrentUser;
import com.edu.eci.cosw.model.Usuario;
import com.edu.eci.cosw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by alejandro on 22/03/17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userService.getUserByEmail(username);

        return new CurrentUser(user);
    }
}