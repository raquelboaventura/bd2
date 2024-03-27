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
                select c.nome,sum(dp.precoVenda * dp. quantidade) as total \s
                from clientes c \s
                left join pedidos p on c.clienteID = p.clienteID\s
                left join detalhes_pedido dp on p.pedidoID = dp.pedidoID\s
                group by c.nome\s
                order by total
                """;
        return db.query(sql,(res,rowNum) -> new ClientePedidoDto(
                res.getString("Nome"),
                res.getDouble("Total")));
    }
}
