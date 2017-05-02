package com.edu.eci.cosw.controllers;

import com.edu.eci.cosw.model.Libro;
import com.edu.eci.cosw.model.Solicitud;
import com.edu.eci.cosw.service.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping(path = "/solicitud")
public class SolicitudController {

    @Autowired
    ApplicationServices services;

    @RequestMapping(path = "/usuario/{username}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<List<Libro>>> getSoliUser(@PathVariable String username) {
        try {
            System.out.print("Siiii  "+username+ "  lllllll");
            return ResponseEntity.ok().body(services.getSolicitudesUsuario(username+".com"));
        } catch (Exception ex) {
            System.out.print("Noooooo  "+username+ "  lllllll");
            Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  
  @RequestMapping(path = "/{id1}/{id2}", method = RequestMethod.POST)
    public ResponseEntity<?> addSoliocitud(@RequestBody Solicitud s, @PathVariable String id1, @PathVariable String id2){
        ResponseEntity a;
        try {

            services.addSolicitud(s,id1,id2);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error!", HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }
}


