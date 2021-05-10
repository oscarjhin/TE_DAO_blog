
package com.emergentes.dao;

import com.emergentes.modelo.Posts;
import com.emergentes.modelo.Usuarios;
import java.util.List;

public interface UsuarioDAO {

    public void insert(Usuarios objeto) throws Exception;
    public void update(Usuarios objeto) throws Exception;
    public void update_pas(int id, String pas) throws Exception;
    public void delete(int id) throws Exception;
    public List<Usuarios> verifica_usuario2(String us, String pas) throws Exception;
    public Usuarios getById(int id) throws Exception;
    public List<Usuarios> getAll() throws Exception;


 
    
    
}
