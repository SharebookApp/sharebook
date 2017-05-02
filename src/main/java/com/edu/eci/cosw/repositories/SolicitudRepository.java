package com.edu.eci.cosw.repositories;

import com.edu.eci.cosw.model.Libro;
import com.edu.eci.cosw.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Diego on 20/03/2017.
 */
public interface SolicitudRepository extends JpaRepository<Solicitud, String>{

    @Query("from Solicitud as s  where s.libro2.usuario.email = ?1")
    List<Solicitud> getSolicitudesUsuario(String useremail);

    @Query("from Solicitud as s  where s.libro1.usuario.email = ?1")
    List<Solicitud> getPeticionesUsuario(String useremail);

    @Query("select libro1 from Solicitud as s where s.id = ?1")
    Libro getLibro1(String idsolicitud);
}
