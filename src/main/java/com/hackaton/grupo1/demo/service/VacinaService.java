package com.hackaton.grupo1.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hackaton.grupo1.demo.dto.VacinaDTO;
import com.hackaton.grupo1.demo.enums.PublicoAlvo;
import com.hackaton.grupo1.demo.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.grupo1.demo.entity.Vacina;
import com.hackaton.grupo1.demo.repository.VacinaRepository;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;


    public List<VacinaDTO> listarTodas() {
        return vacinaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<VacinaDTO> listarPorFaixaEtaria(String faixa) {
        PublicoAlvo publico = PublicoAlvo.valueOf(faixa.toUpperCase());
        return vacinaRepository.findByPublicoAlvo(publico)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<VacinaDTO> listarPorIdadeMaior(int meses) {
        return vacinaRepository.findByLimiteAplicacaoGreaterThan(meses)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VacinaDTO cadastrar(VacinaDTO dto) {
        Vacina vacina = convertToEntity(dto);

        Vacina salva = vacinaRepository.save(vacina);

        return convertToDTO(salva);
    }

    private Vacina convertToEntity(VacinaDTO dto) {
        Vacina vacina = new Vacina();

        vacina.setNome(dto.getNome());
        vacina.setDescricao(dto.getDescricao());
        vacina.setLimiteAplicacao(dto.getLimiteAplicacao());
        vacina.setPublicoAlvo(dto.getPublicoAlvo());

        return vacina;
    }

    private VacinaDTO convertToDTO(Vacina vacina) {
        return new VacinaDTO(
                vacina.getId(),
                vacina.getNome(),
                vacina.getDescricao(),
                vacina.getLimiteAplicacao(),
                vacina.getPublicoAlvo()
        );
    }
}
