package com.edu.eci.cosw.service;

import com.edu.eci.cosw.model.Usuario;

/**
 * Created by alejandro on 22/03/17.
 */
public interface UserService {
    Usuario getUserByEmail(String email);
}
