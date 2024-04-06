package com.bddois.atividade.dao;


import java.util.List;

import com.bddois.atividade.dao.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoriaDao {

    @Autowired
    private JdbcTemplate db;

    public List<Categoria> getCategorias() {

        String sql = "select categoriaID, categoria, descricao from categorias";

        return db.query(sql, (res, rowNum) -> {
            return new Categoria(
                    res.getInt("categoriaID"),
                    res.getString("categoria"),
                    res.getString("descricao"));

        });
    }

    public List<Categoria> getCategorias(String nome) {
        String sql = "select categoriaID, categoria, descricao from categorias where categoria = " + nome + ";";
        return db.query(sql, (res, rowNum) -> {
            return new Categoria(
                    res.getInt("categoriaID"),
                    res.getString("categoria"),
                    res.getString("descricao"));

        });
    }
}
