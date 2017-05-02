package com.edu.eci.cosw.controllers;

import com.edu.eci.cosw.model.Libro;
import com.edu.eci.cosw.service.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Diego on 21/03/2017.
 */
@RestController
@RequestMapping(path = "/libros")
public class LibrosController {

    @Autowired
    ApplicationServices services;

    @RequestMapping(path = "/disponibles/{username}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Libro>> getLibrosDisponibles(@PathVariable String username) {
        try {
            return ResponseEntity.ok().body(services.traerLibrosDisponibles(username+".com"));
        } catch (Exception ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Libro> getLibroById(@PathVariable String id) throws Exception {
        try {
            return ResponseEntity.ok().body(services.getLibroById(id));
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/{id}/picture", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getResourceClientPicture(@PathVariable String id) throws Exception {
        try {
            return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpg")).body(new InputStreamResource(services.getLibroPicture(id)));
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/{useremail}", method = RequestMethod.POST)
    public ResponseEntity<?> addLibro(@RequestBody Libro libro, @PathVariable String useremail){
        ResponseEntity a;
        try {
            services.addLibro(libro, useremail+".com");
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Libro creado sin error");
        } catch (Exception ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error!", HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(path = "/buscar/{bookname}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Libro>> getBuscarLibros(@PathVariable String bookname) {
        try {
            
            System.out.println("ENTRO al api rest buscar : "+bookname);
            return ResponseEntity.ok().body(services.traerLibrosDisponibles(bookname));
            //return ResponseEntity.ok().body(services.traerLibrosDisponibles(bookname));
        } catch (Exception ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{idlibro}/picture", method = RequestMethod.POST)
    public ResponseEntity<?> addLibroPicture(@RequestBody File file, @PathVariable String idlibro){
        ResponseEntity a;
        try {

            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("imagen creado sin error   "+file);
        } catch (Exception ex) {
            Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error!", HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

}
