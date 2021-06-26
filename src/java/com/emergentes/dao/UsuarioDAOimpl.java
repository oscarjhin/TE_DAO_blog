
package com.emergentes.dao;

import com.emergentes.ConexionDB;
import com.emergentes.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO{

    @Override
    public List<Usuario> verifica_usuario2(String us, String pas) throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuario where usuario=? and contrasena=?");
            ps.setString(1, us);
            ps.setString(2, pas);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setCi(rs.getString("ci"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setNombres(rs.getString("nombres"));
                usu.setEmail(rs.getString("email"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setContrasena(rs.getString("contrasena"));
                usu.setId_cat_usuario(rs.getInt("id_cat_usuario"));

                lista.add(usu);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return lista;
    }

    @Override
    public Usuario getById(String id) throws Exception {
        Usuario usu = new Usuario();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuario where ci=? ORDER By apellidos, nombres");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usu.setCi(rs.getString("ci"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setNombres(rs.getString("nombres"));
                usu.setEmail(rs.getString("email"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setContrasena(rs.getString("contrasena"));
                usu.setId_cat_usuario(rs.getInt("id_cat_usuario"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return usu;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuario ORDER By apellidos, nombres");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario usu = new Usuario();
                
                usu.setCi(rs.getString("ci"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setNombres(rs.getString("nombres"));
                usu.setEmail(rs.getString("email"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setContrasena(rs.getString("contrasena"));
                usu.setId_cat_usuario(rs.getInt("id_cat_usuario"));
                lista.add(usu);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return lista;
    }

    @Override
    public void insert(Usuario objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuario(ci, apellidos, nombres, email, usuario, contrasena, id_cat_usuario) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, objeto.getCi());
            ps.setString(2, objeto.getApellidos());
            ps.setString(3, objeto.getNombres());
            ps.setString(4, objeto.getEmail());
            ps.setString(5, objeto.getUsuario());
            ps.setString(6, objeto.getContrasena());
            ps.setInt(7, objeto.getId_cat_usuario());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuario objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuario SET ci=?, apellidos=?,nombres=?,email=?,usuario=?,contrasena=?,id_cat_usuario=? WHERE ci=?");
           
            ps.setString(1, objeto.getCi());
            ps.setString(2, objeto.getApellidos());
            ps.setString(3, objeto.getNombres());
            ps.setString(4, objeto.getEmail());
            ps.setString(5, objeto.getUsuario());
            ps.setString(6, objeto.getContrasena());
            ps.setInt(7, objeto.getId_cat_usuario());
            ps.setString(8, objeto.getCi_ant());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from usuario where ci = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update_pas(String id, String pas) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuario SET contrasena=? WHERE ci=?");;
            ps.setString(1, pas);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public boolean getByIdExist(String id) throws Exception {
        boolean res=false;
        Usuario usu = new Usuario();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuario where ci=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                res=true;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return res;
        
        
    }

   
}
