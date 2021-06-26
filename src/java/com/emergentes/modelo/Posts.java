package com.emergentes.modelo;

import java.io.InputStream;

public class Posts {

    private int id;
    private String fecha;
    private String titulo;
    private String descripcion;
    private Double precio;
    private int nro_celular;
    private int id_cat_aviso;
    private String id_usuario;

    InputStream archivoimg;
    private byte[] archivoimg2;

    public Posts() {
        this.id = 0;
        this.fecha = "";
        this.titulo = "";
        this.descripcion = "";
        this.precio=0.0;
        this.nro_celular=0;
        this.id_cat_aviso=0;
        this.id_usuario = "";
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getNro_celular() {
        return nro_celular;
    }

    public void setNro_celular(int nro_celular) {
        this.nro_celular = nro_celular;
    }

    public int getId_cat_aviso() {
        return id_cat_aviso;
    }

    public void setId_cat_aviso(int id_cat_aviso) {
        this.id_cat_aviso = id_cat_aviso;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public InputStream getArchivoimg() {
        return archivoimg;
    }

    public void setArchivoimg(InputStream archivoimg) {
        this.archivoimg = archivoimg;
    }

    public byte[] getArchivoimg2() {
        return archivoimg2;
    }

    public void setArchivoimg2(byte[] archivoimg2) {
        this.archivoimg2 = archivoimg2;
    }


    

}
