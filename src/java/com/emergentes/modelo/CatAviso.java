package com.emergentes.modelo;

public class CatAviso {

    private int id;
    private String descripcion;

    public CatAviso() {
        this.id = 0;
        this.descripcion = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
