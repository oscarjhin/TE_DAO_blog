
package com.emergentes.dao;

import com.emergentes.modelo.Posts;
import java.util.List;

public interface PostsDAO {
    public void insert(Posts objeto) throws Exception;
    public void update(Posts objeto) throws Exception;
    public void delete(int id) throws Exception;
    public Posts getById(int id) throws Exception;
    public List<Posts> getAll() throws Exception;
    public List<Posts> getAll_IdUsuario(int id_us) throws Exception;
 
    
    
}
