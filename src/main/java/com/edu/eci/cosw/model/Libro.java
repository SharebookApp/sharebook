package com.edu.eci.cosw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;


/**
 * Created by Diego
 */

@Entity
@Table(name = "LIBROS")
public class Libro implements Serializable {


    private String id;

    private String nombre;

    private String editorial;

    private String autor;

    private Blob imagen;

    private Float latitude;

    private Float longitude;

    private Usuario usuario;

    public Libro(String id, String nombre, String editorial, String autor, Blob imagen, Float latitude, Float longitude, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.imagen = imagen;
        this.latitude = latitude;
        this.longitude = longitude;
        this.usuario = usuario;
    }

    public Libro(){

    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "editorial")
    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Column(name = "autor")
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Column(name="imagen")
    @JsonIgnore
    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    @Column(name="latitude")
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @Column(name="longitude")
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIOS_email", nullable = false)
    @Fetch(FetchMode.JOIN)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
