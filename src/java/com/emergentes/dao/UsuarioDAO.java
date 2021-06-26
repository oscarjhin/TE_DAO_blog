
package com.emergentes.dao;

import com.emergentes.modelo.Posts;
import com.emergentes.modelo.Usuario;
import java.util.List;

public interface UsuarioDAO {

   public void insert(Usuario objeto) throws Exception;
    public void update(Usuario objeto) throws Exception;
    public void update_pas(String id, String pas) throws Exception;
    public void delete(String id) throws Exception;
    public List<Usuario> verifica_usuario2(String us, String pas) throws Exception;
    public Usuario getById(String id) throws Exception;
    public boolean getByIdExist(String id) throws Exception;
    public List<Usuario> getAll() throws Exception;
   
    
}
