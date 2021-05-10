
package com.emergentes.dao;

import com.emergentes.ConexionDB;
import com.emergentes.modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO{

    @Override
    public List<Usuarios> verifica_usuario2(String us, String pas) throws Exception {
        List<Usuarios> lista= null;
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT * FROM usuarios where usuario=? and password=?");
            ps.setString(1, us);
            ps.setString(2, pas);
            
            ResultSet rs = ps.executeQuery();
            
            
            lista = new ArrayList<Usuarios>();
            while (rs.next()) {
                Usuarios usu=new Usuarios();
                usu.setId(rs.getInt("id"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                lista.add(usu);
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
    public Usuarios getById(int id) throws Exception {
        Usuarios usu= new Usuarios();
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT * FROM usuarios where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                usu.setId(rs.getInt("id"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
            }
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        } 
        
        return usu;
    }

    @Override
    public List<Usuarios> getAll() throws Exception {
        List<Usuarios> lista= null;
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            
            
            lista = new ArrayList<Usuarios>();
            while (rs.next()) {
                Usuarios usu=new Usuarios();
                usu.setId(rs.getInt("id"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                lista.add(usu);
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
    public void insert(Usuarios objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("insert into usuarios (usuario, password) values (?,?);");
            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Usuarios objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("UPDATE usuarios SET usuario=?, password=? WHERE id=?");
            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getPassword());
            ps.setInt(3, objeto.getId());
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
            PreparedStatement ps=this.conn.prepareStatement("delete from usuarios where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update_pas(int id, String pas) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps=this.conn.prepareStatement("UPDATE usuarios SET password=? WHERE id=?");;
            ps.setString(1, pas);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }

   
}
