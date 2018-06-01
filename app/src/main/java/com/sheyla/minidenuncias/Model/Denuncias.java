package com.sheyla.minidenuncias.Model;

/**
 * Created by Sheyla on 25/05/2018.
 */

public class Denuncias {


    private int id;
    private String pfoto;
    private String ubicacion;
    private String descripcion;
    private String titulo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPfoto() {
        return pfoto;
    }

    public void setPfoto(String pfoto) {
        this.pfoto = pfoto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



}
