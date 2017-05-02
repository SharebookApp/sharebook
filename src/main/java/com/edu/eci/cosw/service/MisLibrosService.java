package com.edu.eci.cosw.service;

import com.edu.eci.cosw.model.Libro;
import com.edu.eci.cosw.model.ManejadorMisLibros;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santiago on 28/02/17.
 */
@Service
public class MisLibrosService implements ManejadorMisLibros {
    List<Libro> misLibros = new ArrayList<>();

    public MisLibrosService() {
       // misLibros.add(new Libro("1","Cien Años De Soldedad","Norma","Gabriel Garcia Marquez"));
       // misLibros.add(new Libro("2","El Otoño Del Patriarca","Norma","Gabriel Garcia Marquez"));
    }

    @Override
    public List<Libro> getMisLibros() {
        return misLibros;
    }
}
