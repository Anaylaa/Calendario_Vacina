package com.hackaton.grupo1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.grupo1.demo.entity.Imunizacao;

@Repository
public interface ImunizacaoRepository extends JpaRepository<Imunizacao, Long> {
}