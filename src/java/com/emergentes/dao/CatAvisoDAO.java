package com.emergentes.dao;

import com.emergentes.modelo.CatAviso;
import java.util.List;

public interface CatAvisoDAO {

    public void insert(CatAviso objeto) throws Exception;

    public void update(CatAviso objeto) throws Exception;

    public void delete(int id) throws Exception;

    public CatAviso getById(int id) throws Exception;

    public List<CatAviso> getAll() throws Exception;

}
