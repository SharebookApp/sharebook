package com.edu.eci.cosw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by Diego on 20/03/2017.
 */

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

    private String email;

    @NotEmpty
    @JsonIgnore
    private String password;
    @NotEmpty
    private String nombre;
    private String celular;
    private Blob imagen;

    @NotEmpty
    private Role role;

    public Usuario(String nombre, String password, String email, String celular, Blob imagen) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.celular = celular;
        this.imagen = imagen;
    }

    public Usuario(){
    }




    @Id
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(name = "celular")
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    @Column(name = "imagen")
    @JsonIgnore
    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
