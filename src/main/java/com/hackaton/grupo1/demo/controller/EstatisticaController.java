package com.hackaton.grupo1.demo.controller;

import com.hackaton.grupo1.demo.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticaController {

    @Autowired
    private EstatisticaService service;

    @GetMapping("/imunizacoes/paciente/{id}")
    public ResponseEntity<Long> qtdePorPaciente(@PathVariable Integer id) {
        return ResponseEntity.ok(service.contarImunizacoesPorPaciente(id));
    }

    @GetMapping("/proximas_imunizacoes/paciente/{id}")
    public ResponseEntity<Long> qtdeProximoMes(@PathVariable Integer id) {
        return ResponseEntity.ok(service.contarProximasVacinas(id));
    }

    @GetMapping("/imunizacoes_atrasadas/paciente/{id}")
    public ResponseEntity<Long> qtdeAtrasadas(@PathVariable Integer id) {
        return ResponseEntity.ok(service.contarVacinasAtrasadas(id));
    }

    @GetMapping("/imunizacoes/idade_maior/{meses}")
    public ResponseEntity<Long> qtdeAcimaIdade(@PathVariable int meses) {
        return ResponseEntity.ok(service.contarVacinasAcimaDaIdade(meses));
    }
}
