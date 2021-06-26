package com.emergentes.modelo;

public class Usuario {

    private String ci;
    private String ci_ant;
    private String apellidos;
    private String nombres;
    private String email;
    private String usuario;
    private String contrasena;
    private int id_cat_usuario;

    public Usuario() {
        this.ci="";
        this.apellidos="";
        this.nombres="";
        this.email="";        
        this.usuario = "";
        this.contrasena="";
        //this.id_cat_usuario=0;

    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getId_cat_usuario() {
        return id_cat_usuario;
    }

    public void setId_cat_usuario(int id_cat_usuario) {
        this.id_cat_usuario = id_cat_usuario;
    }

    public String getCi_ant() {
        return ci_ant;
    }

    public void setCi_ant(String ci_ant) {
        this.ci_ant = ci_ant;
    }

    
    
    @Override
    public String toString() {
        return "Usuario{" + "ci=" + ci + ", apellidos=" + apellidos + ", nombres=" + nombres + ", email=" + email + ", usuario=" + usuario + ", contrasena=" + contrasena + ", id_cat_usuario=" + id_cat_usuario + '}';
    }

    

}
