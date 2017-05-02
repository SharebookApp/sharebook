package com.edu.eci.cosw.model;

import java.util.List;

/**
 * Created by santiago on 28/02/17.
 */
public interface ManejadorTodosLosLibros {

    public List<Libro> getTodosLosLibros();
    public Libro getLibro(String nombre);

}
