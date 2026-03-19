package com.hackaton.grupo1.demo.dto;

import com.hackaton.grupo1.demo.enums.PublicoAlvo;

public class VacinaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private int limiteAplicacao;
    private PublicoAlvo publicoAlvo;

    public VacinaDTO(){

    }

    public VacinaDTO(String nome, String descricao, int limiteAplicacao, PublicoAlvo publicoAlvo){
        this.nome = nome;
        this.descricao = descricao;
        this.limiteAplicacao = limiteAplicacao;
        this.publicoAlvo = publicoAlvo;
    }

    public VacinaDTO(Integer id, String nome, String descricao, int limiteAplicacao, PublicoAlvo publicoAlvo){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.limiteAplicacao = limiteAplicacao;
        this.publicoAlvo = publicoAlvo;
    }
}
