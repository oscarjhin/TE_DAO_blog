package com.emergentes.dao;

import com.emergentes.ConexionDB;
import com.emergentes.modelo.CatAviso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CatAvisoDAOimpl extends ConexionDB implements CatAvisoDAO {

    @Override
    public void insert(CatAviso objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO cat_aviso(descripcion) VALUES (?)");
            ps.setString(1, objeto.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(CatAviso objeto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE cat_aviso SET descripcion=? WHERE id=?");
            ps.setString(1, objeto.getDescripcion());
            ps.setInt(2, objeto.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM cat_aviso WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public CatAviso getById(int id) throws Exception {
        CatAviso objeto = new CatAviso();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cat_aviso where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                objeto.setId(rs.getInt("id"));
                objeto.setDescripcion(rs.getString("descripcion"));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return objeto;
    }

    @Override
    public List<CatAviso> getAll() throws Exception {
        List<CatAviso> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cat_aviso");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<CatAviso>();
            while (rs.next()) {
                CatAviso objeto = new CatAviso();
                objeto.setId(rs.getInt("id"));
                objeto.setDescripcion(rs.getString("descripcion"));
                lista.add(objeto);
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
