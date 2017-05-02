package com.edu.eci.cosw.controllers;

import com.edu.eci.cosw.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alejandro on 11/02/17.
 */
@RestController
public class UsersController {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/app/user", method = RequestMethod.GET)
    ResponseEntity<?> login(Principal user){

        try {

            return ResponseEntity.ok().body(user);
        } catch (Exception ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }




}
