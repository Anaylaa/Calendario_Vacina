package com.hackaton.grupo1.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.grupo1.demo.entity.Imunizacao;
import com.hackaton.grupo1.demo.repository.ImunizacaoRepository;

@Service
public class ImunizacaoService {

    @Autowired
    private ImunizacaoRepository repository;

    public void teste() {
        List<Imunizacao> lista = repository.findAll();

        for (Imunizacao i : lista) {
            System.out.println(i.getFabricante());
        }
    }
}