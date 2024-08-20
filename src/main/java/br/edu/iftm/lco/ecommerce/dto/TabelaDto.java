package br.edu.iftm.lco.ecommerce.dto;

import java.util.Map;

public class TabelaDto {
    private Map<String, Object> dados;

    public TabelaDto(Map<String, Object> dados) {
        this.dados = dados;
    }

    // Getters para acessar os dados
    public Map<String, Object> getDados() {
        return dados;
    }
}
