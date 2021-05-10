package com.emergentes.modelo;

public class Posts {

    private int id;
    private String fecha;
    private String titulo;
    private String contenido;
    private int id_usuario;

    public Posts() {
        this.id = 0;
        this.fecha = "";
        this.titulo = "";
        this.contenido = "";
        this.id_usuario = 0;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }



    

}
