package com.edu.eci.cosw.controllers;

import com.edu.eci.cosw.model.Libro;
import com.edu.eci.cosw.service.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by santiago on 20/02/17.
 */

@RestController
@RequestMapping(value= "/mislibros")
public class MisLibrosController {


    @Autowired
    ApplicationServices services;


    @RequestMapping(path = "/{username}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Libro>> getMisLibrosDisponibles(@PathVariable String username) {
        try {

            //System.out.println("uSUARIO" + username);
            return ResponseEntity.ok().body(services.traerMisLibros(username+".com"));
        } catch (Exception ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
