package com.bddois.atividade.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientePedidoDto {
    private String nome;
    private Double total;

}
