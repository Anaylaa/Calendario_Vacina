package com.hackaton.grupo1.demo.entity;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dose")
public class Dose {

    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dose")
    private Integer id;
    @Column(name = "descricao_dose", length = 45, nullable = false)
    private String descricao;
    @Column(name = "idade_recomendada_aplicacao")
    private int idadeRecomendadaAplicacao;
    
}
