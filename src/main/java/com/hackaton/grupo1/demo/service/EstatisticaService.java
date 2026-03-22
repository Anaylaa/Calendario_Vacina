package com.hackaton.grupo1.demo.service;

import com.hackaton.grupo1.demo.entity.Paciente;
import com.hackaton.grupo1.demo.entity.Vacina;
import com.hackaton.grupo1.demo.exceptions.ResourceNotFoundException;
import com.hackaton.grupo1.demo.repository.ImunizacaoRepository;
import com.hackaton.grupo1.demo.repository.PacienteRepository;
import com.hackaton.grupo1.demo.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class EstatisticaService {

    @Autowired
    private ImunizacaoRepository imunizacaoRepository;
    @Autowired
    private VacinaRepository vacinaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public long contarImunizacoesPorPaciente(Integer idPaciente) {
        validarPaciente(idPaciente);
        return imunizacaoRepository.countByPacienteId(idPaciente);
    }

    public long contarVacinasAcimaDaIdade(int meses) {
        return vacinaRepository.countByLimiteAplicacaoGreaterThan(meses);
    }

    public long contarVacinasAtrasadas(Integer idPaciente) {
        Paciente paciente = validarPaciente(idPaciente);
        int idadeMeses = calcularIdadeEmMeses(paciente.getData_nascimento());
        List<Vacina> naoTomadas = vacinaRepository.findVacinasNaoAplicadas(idPaciente);
        return naoTomadas.stream()
                .filter(v -> v.getLimiteAplicacao() != null && v.getLimiteAplicacao() < idadeMeses)
                .count();
    }

    public long contarProximasVacinas(Integer idPaciente) {
        Paciente paciente = validarPaciente(idPaciente);
        int idadeMeses = calcularIdadeEmMeses(paciente.getData_nascimento());
        int proximoMes = idadeMeses + 1;

        List<Vacina> naoTomadas = vacinaRepository.findVacinasNaoAplicadas(idPaciente);
        return naoTomadas.stream()
                .filter(v -> v.getLimiteAplicacao() != null && v.getLimiteAplicacao() == proximoMes)
                .count();
    }

    private Paciente validarPaciente(Integer id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));
    }

    private int calcularIdadeEmMeses(LocalDate nascimento) {
        Period periodo = Period.between(nascimento, LocalDate.now());
        return (periodo.getYears() * 12) + periodo.getMonths();
    }
}
