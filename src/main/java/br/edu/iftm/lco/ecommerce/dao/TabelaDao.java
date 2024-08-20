package br.edu.iftm.lco.ecommerce.dao;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
@Log4j2
public class TabelaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> listarDadosTabela(String nomeTabela) {
        log.info("Entrando no DAO!");
        try{
            return jdbcTemplate.queryForList("CALL listaDadostabela(?)", nomeTabela);
        }
        catch (NullPointerException NE){
            log.error(String.format("Erro ao consultar os dados da tabela: %s", NE));
            throw NE;
        }
        catch (Exception ex){
            log.error(String.format("Erro ao consultar dados da tabela: %s", ex));
            throw ex;
        }
    }
}