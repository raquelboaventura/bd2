package com.bddois.atividade.Controller;

import com.bddois.atividade.dao.CategoriaDao;
import com.bddois.atividade.dao.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriaController{
    @Autowired
    CategoriaDao categoriaDao;

    @Autowired
    private JdbcTemplate db;

    @GetMapping("/categorias")
    public List<Categoria> getCategorias() {
        return categoriaDao.getCategorias();
    }

    @GetMapping("/categoria/{nome}")
    public ResponseEntity<List<Categoria>> GetByNome(@PathVariable(value = "nome") String nome) {
        List<Categoria> categorias = categoriaDao.getCategorias(nome);
        if (categorias.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(categorias);
    }

}