package com.juliana.entrega_4;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Usuario {
    private String nombre;
    private String cargo;
    private String correo;


    public Usuario() {
    }

    public Usuario(String nombre, String cargo, String correo) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCargo() {
        return cargo;
    }
}
