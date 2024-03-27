package com.bddois.atividade.dao;

import com.bddois.atividade.Dto.ClientePedidoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientePedidoDao {

    @Autowired
    private JdbcTemplate db;

    public List<ClientePedidoDto> getClientesPedidos(){
        String sql = """
                select * from view_pedidos_clientes;
                """;
        return db.query(sql,(res,rowNum) -> new ClientePedidoDto(
                res.getString("Nome"),
                res.getDouble("Total")));
    }
}
