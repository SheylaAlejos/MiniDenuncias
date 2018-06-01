package com.sheyla.minidenuncias.Model;

/**
 * Created by Sheyla on 25/05/2018.
 */

public class Usuarios {

    private Integer id;
    private String nombre;
    private String apellido;
    private String username;



    private String password;
    private String distrito;
    private String tipo;

    public String getTipoUser() {
        return tipo;
    }



    public Usuarios(Integer id, String nombre, String apellido, String username, String password, String distrito, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.distrito = distrito;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", distrito='" + distrito + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}
