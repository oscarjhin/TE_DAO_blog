
package com.emergentes.dao;

import com.emergentes.ConexionDB;
import com.emergentes.modelo.Posts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PostsDAOimpl extends ConexionDB implements PostsDAO{

    @Override
    public void insert(Posts objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("insert into posts (fecha, titulo, contenido, id_usuario) values (?,?,?,?);");
            ps.setString(1, objeto.getFecha());
            ps.setString(2, objeto.getTitulo());
            ps.setString(3, objeto.getContenido());
            ps.setInt(4, objeto.getId_usuario());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Posts objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("UPDATE posts SET fecha=?, titulo=?, contenido =?, id_usuario=? WHERE id=?");
            ps.setString(1, objeto.getFecha());
            ps.setString(2, objeto.getTitulo());
            ps.setString(3, objeto.getContenido());
            ps.setInt(4, objeto.getId_usuario());
            ps.setInt(5, objeto.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("delete from posts where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Posts getById(int id) throws Exception {
        Posts post= new Posts();
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT * FROM posts where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                post.setId(rs.getInt("id"));
                post.setFecha(rs.getString("fecha"));
                post.setTitulo(rs.getString("titulo"));
                post.setContenido(rs.getString("contenido"));
                post.setId_usuario(rs.getInt("id_usuario"));
            }
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        } 
        
        return post;
    }

    @Override
    public List<Posts> getAll() throws Exception {
        List<Posts> lista= null;
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT * FROM posts ORDER BY fecha DESC");
            ResultSet rs = ps.executeQuery();
            
            
            lista = new ArrayList<Posts>();
            while (rs.next()) {
                Posts post=new Posts();
                post.setId(rs.getInt("id"));
                post.setFecha(rs.getString("fecha"));
                post.setTitulo(rs.getString("titulo"));
                post.setContenido(rs.getString("contenido"));
                post.setId_usuario(rs.getInt("id_usuario"));
                lista.add(post);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        } 
        
        return lista;
    }

    @Override
    public List<Posts> getAll_IdUsuario(int id_us) throws Exception {
        List<Posts> lista= null;
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT * FROM posts where id_usuario=? ORDER BY fecha DESC");
            ps.setInt(1, id_us);
            ResultSet rs = ps.executeQuery();
            
            
            lista = new ArrayList<Posts>();
            while (rs.next()) {
                Posts post=new Posts();
                post.setId(rs.getInt("id"));
                post.setFecha(rs.getString("fecha"));
                post.setTitulo(rs.getString("titulo"));
                post.setContenido(rs.getString("contenido"));
                post.setId_usuario(rs.getInt("id_usuario"));
                lista.add(post);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        } 
        
        return lista;
    }

    
    
}
