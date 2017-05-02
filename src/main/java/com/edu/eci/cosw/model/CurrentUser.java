package com.edu.eci.cosw.model;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by alejandro on 24/03/17.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private Usuario user;

    public CurrentUser(Usuario user) {
        super(user.getNombre(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }

    public Role getRole() {
        return user.getRole();
    }
}
