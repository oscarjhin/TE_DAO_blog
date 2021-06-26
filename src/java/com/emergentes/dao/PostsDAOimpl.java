
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
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO aviso(fecha, titulo, descripcion, precio, nro_celular, imagen, id_cat_aviso, id_usuario) VALUES (?,?,?,?,?,?,?,?);");
            ps.setString(1, objeto.getFecha());
            ps.setString(2, objeto.getTitulo());
            ps.setString(3, objeto.getDescripcion());
            ps.setDouble(4, objeto.getPrecio());
            ps.setInt(5, objeto.getNro_celular());         
            ps.setBlob(6, objeto.getArchivoimg());           
            ps.setInt(7, objeto.getId_cat_aviso());
            ps.setString(8, objeto.getId_usuario());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
        @Override
    public void update(Posts objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE aviso SET fecha=?,titulo=?,descripcion=?,precio=?,nro_celular=?,imagen=?,id_cat_aviso=?,id_usuario=? WHERE id=?");
            ps.setString(1, objeto.getFecha());
            ps.setString(2, objeto.getTitulo());
            ps.setString(3, objeto.getDescripcion());
            ps.setDouble(4, objeto.getPrecio());
            ps.setInt(5, objeto.getNro_celular());         
            ps.setBlob(6, objeto.getArchivoimg());           
            ps.setInt(7, objeto.getId_cat_aviso());
            ps.setString(8, objeto.getId_usuario());
            ps.setInt(9, objeto.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update2(Posts objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE aviso SET fecha=?,titulo=?,descripcion=?,precio=?,nro_celular=?,id_cat_aviso=?,id_usuario=? WHERE id=?");
            ps.setString(1, objeto.getFecha());
            ps.setString(2, objeto.getTitulo());
            ps.setString(3, objeto.getDescripcion());
            ps.setDouble(4, objeto.getPrecio());
            ps.setInt(5, objeto.getNro_celular());                    
            ps.setInt(6, objeto.getId_cat_aviso());
            ps.setString(7, objeto.getId_usuario());
            ps.setInt(8, objeto.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from aviso where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Posts getById(int id) throws Exception {
        Posts aviso = new Posts();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM aviso where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                aviso.setId(rs.getInt("id"));
                aviso.setFecha(rs.getString("fecha"));
                aviso.setTitulo(rs.getString("titulo"));
                aviso.setDescripcion(rs.getString("descripcion"));
                aviso.setPrecio(rs.getDouble("precio"));
                aviso.setNro_celular(rs.getInt("nro_celular"));               
                aviso.setArchivoimg2(rs.getBytes("imagen"));
                aviso.setId_cat_aviso(rs.getInt("id_cat_aviso"));
                aviso.setId_usuario(rs.getString("id_usuario"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return aviso;
    }

    @Override
    public List<Posts> getAll() throws Exception {
        List<Posts> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM aviso ORDER BY fecha DESC");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Posts>();
            while (rs.next()) {
                Posts aviso = new Posts();
                aviso.setId(rs.getInt("id"));
                aviso.setFecha(rs.getString("fecha"));
                aviso.setTitulo(rs.getString("titulo"));
                aviso.setDescripcion(rs.getString("descripcion"));
                aviso.setPrecio(rs.getDouble("precio"));
                aviso.setNro_celular(rs.getInt("nro_celular"));               
                aviso.setArchivoimg2(rs.getBytes("imagen"));
                aviso.setId_cat_aviso(rs.getInt("id_cat_aviso"));
                aviso.setId_usuario(rs.getString("id_usuario"));
                lista.add(aviso);
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
    public List<Posts> getAll_IdUsuario(String id_us) throws Exception {
        List<Posts> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM aviso where id_usuario=? ORDER BY fecha DESC");
            ps.setString(1, id_us);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Posts>();
            while (rs.next()) {
                Posts aviso = new Posts();
                aviso.setId(rs.getInt("id"));
                aviso.setFecha(rs.getString("fecha"));
                aviso.setTitulo(rs.getString("titulo"));
                aviso.setDescripcion(rs.getString("descripcion"));
                aviso.setPrecio(rs.getDouble("precio"));
                aviso.setNro_celular(rs.getInt("nro_celular"));               
                aviso.setArchivoimg2(rs.getBytes("imagen"));
                aviso.setId_cat_aviso(rs.getInt("id_cat_aviso"));
                aviso.setId_usuario(rs.getString("id_usuario"));
                lista.add(aviso);
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

    
    
}
