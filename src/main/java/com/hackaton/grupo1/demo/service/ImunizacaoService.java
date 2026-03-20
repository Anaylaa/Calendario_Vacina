package com.hackaton.grupo1.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hackaton.grupo1.demo.entity.Dose;
import com.hackaton.grupo1.demo.entity.Paciente;
import com.hackaton.grupo1.demo.exceptions.ResourceNotFoundException;
import com.hackaton.grupo1.demo.repository.DoseRepository;
import com.hackaton.grupo1.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.grupo1.demo.entity.Imunizacao;
import com.hackaton.grupo1.demo.repository.ImunizacaoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImunizacaoService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoseRepository doseRepository;

    @Autowired
    private ImunizacaoRepository imunizacaoRepository;

    public Imunizacao salvar(Imunizacao imunizacao) {
        Paciente paciente = pacienteRepository.findById(imunizacao.getPaciente().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado."));

        Dose dose = doseRepository.findById(imunizacao.getDose().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Dose não encontrada."));
        imunizacao.setPaciente(paciente);
        imunizacao.setDose(dose);

        return imunizacaoRepository.save(imunizacao);
    }

    public Imunizacao alterar(Integer id, Imunizacao dadosAtualizados) {
        Imunizacao imunizacao = imunizacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Imunização não encontrada."));

        if (dadosAtualizados.getDataAplicacao() != null)
            imunizacao.setDataAplicacao(dadosAtualizados.getDataAplicacao());
        if (dadosAtualizados.getFabricante() != null)
            imunizacao.setFabricante(dadosAtualizados.getFabricante());
        if (dadosAtualizados.getLote() != null)
            imunizacao.setLote(dadosAtualizados.getLote());
        if (dadosAtualizados.getLocalAplicacao() != null)
            imunizacao.setLocalAplicacao(dadosAtualizados.getLocalAplicacao());
        if (dadosAtualizados.getProfissionalAplicador() != null)
            imunizacao.setProfissionalAplicador(dadosAtualizados.getProfissionalAplicador());

        return imunizacaoRepository.save(imunizacao);
    }

    public void excluir(Integer id) {
        if (!imunizacaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Imunização não encontrada.");
        }
        imunizacaoRepository.deleteById(id);
    }

    @Transactional
    public void excluirPorPaciente(Integer idPaciente) {
        if (!pacienteRepository.existsById(idPaciente)) {
            throw new ResourceNotFoundException("Paciente não encontrado.");
        }
        imunizacaoRepository.deleteByPaciente_Id(idPaciente);
    }

    public List<Imunizacao> consultarTodas() {
        return imunizacaoRepository.findAll();
    }

    public Optional<Imunizacao> consultarPorId(Integer id) {
        return imunizacaoRepository.findById(id);
    }

    public List<Imunizacao> consultarPorPaciente(Integer idPaciente) {
        if (!pacienteRepository.existsById(idPaciente)) {
            throw new ResourceNotFoundException("Paciente não encontrado.");
        }
        return imunizacaoRepository.findByPaciente_Id(idPaciente);
    }

    public List<Imunizacao> consultarPorPacienteEPeriodo(Integer idPaciente,
                                                         LocalDate dataInicio,
                                                         LocalDate dataFim) {
        if (!pacienteRepository.existsById(idPaciente)) {
            throw new ResourceNotFoundException("Paciente não encontrado.");
        }
        return imunizacaoRepository.findByPaciente_IdAndDataAplicacaoBetween(
                idPaciente, dataInicio, dataFim);
    }
}