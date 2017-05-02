package com.edu.eci.cosw.repositories;


import com.edu.eci.cosw.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Blob;
import java.util.List;

/**
 * Created by Diego on 20/03/2017.
 */
public interface LibroRepository extends JpaRepository<Libro,String>{


    @Query("from Libro as l where l.usuario.email != ?1")
    List<Libro> getLibrosDisponibles(String useremail);

    @Query("from Libro as l where l.usuario.email = ?1")
    List<Libro> getMisLibrosDisponibles(String useremail);

    @Query("select imagen from Libro as l where l.id = ?1")
    Blob getLibroPicture(String id);
}
