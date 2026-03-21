package com.hackaton.grupo1.demo.dto;

import com.hackaton.grupo1.demo.enums.PublicoAlvo;

public class VacinaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer limiteAplicacao;
    private PublicoAlvo publicoAlvo;

    public VacinaDTO(){

    }

    public VacinaDTO(String nome, String descricao, Integer limiteAplicacao, PublicoAlvo publicoAlvo){
        this.nome = nome;
        this.descricao = descricao;
        this.limiteAplicacao = limiteAplicacao;
        this.publicoAlvo = publicoAlvo;
    }

    public VacinaDTO(Integer id, String nome, String descricao, Integer limiteAplicacao, PublicoAlvo publicoAlvo){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.limiteAplicacao = limiteAplicacao;
        this.publicoAlvo = publicoAlvo;
    }

    public PublicoAlvo getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(PublicoAlvo publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    public Integer getLimiteAplicacao() {
        return limiteAplicacao;
    }

    public void setLimiteAplicacao(Integer limiteAplicacao) {
        this.limiteAplicacao = limiteAplicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
