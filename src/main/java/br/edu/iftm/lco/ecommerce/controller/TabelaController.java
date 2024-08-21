package br.edu.iftm.lco.ecommerce.controller;

import br.edu.iftm.lco.ecommerce.dao.TabelaDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequestMapping("/tabelas")
public class TabelaController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TabelaDao tabelaDao;

    @GetMapping("/{nomeTabela}")
    public List<Map<String, Object>> listarDadosTabela(@PathVariable String nomeTabela) {
        log.info("Entrando no controller de Tabelas");
        return tabelaDao.listarDadosTabela(nomeTabela);
    }
}