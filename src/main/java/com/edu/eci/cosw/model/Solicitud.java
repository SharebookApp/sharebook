package com.edu.eci.cosw.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Diego on 20/03/2017.
 */

@Entity
@Table(name = "SOLICITUDES")
public class Solicitud implements Serializable {


    private String Id;
    private Date fecha;
    private boolean estado;
    private Libro libro1;
    private Libro libro2;

    public Solicitud(){

    }

    public Solicitud(String id, Date fecha, boolean estado, Libro libro1, Libro libro2) {
        Id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.libro1 = libro1;
        this.libro2 = libro2;
    }

    @Id
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    @Column(name = "estado")
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LIBROS_Id1", nullable = false)
    @Fetch(FetchMode.JOIN)
    public Libro getLibro1() {
        return libro1;
    }

    public void setLibro1(Libro libro1) {
        this.libro1 = libro1;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LIBROS_Id2", nullable = false)
    @Fetch(FetchMode.JOIN)
    public Libro getLibro2() {
        return libro2;
    }

    public void setLibro2(Libro libro2) {
        this.libro2 = libro2;
    }

}
