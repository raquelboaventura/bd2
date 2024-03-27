package com.bddois.atividade.Controller;

import com.bddois.atividade.Dto.ClientePedidoDto;
import com.bddois.atividade.dao.ClientePedidoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class ClientePedidoController {

    @Autowired
    private ClientePedidoDao clientePedidoDao;

    @GetMapping("clientePedido")
    public List<ClientePedidoDto> getClientesPedidos(){
        return clientePedidoDao.getClientesPedidos();
    }

}
