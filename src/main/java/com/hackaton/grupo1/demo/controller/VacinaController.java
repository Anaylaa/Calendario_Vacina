package com.hackaton.grupo1.demo.controller;

import com.hackaton.grupo1.demo.entity.Vacina;
import com.hackaton.grupo1.demo.service.VacinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {

    private final VacinaService vacinaService;

    public VacinaController(VacinaService vacinaService) {
        this.vacinaService = vacinaService;
    }

    // Listar todas as vacinas
    @GetMapping
    public ResponseEntity<List<Vacina>> getAllVacinas() {
        List<Vacina> vacinas = vacinaService.listarTodas();
        return ResponseEntity.ok(vacinas);
    }

    // Buscar vacina por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vacina> getVacinaById(@PathVariable Integer id) {
        try {
            Vacina vacina = vacinaService.buscarPorId(id);
            return ResponseEntity.ok(vacina);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar nova vacina
    @PostMapping
    public ResponseEntity<Vacina> createVacina(@RequestBody Vacina vacina) {
        try {
            Vacina novaVacina = vacinaService.salvar(vacina);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaVacina);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Atualizar vacina existente
    @PutMapping("/{id}")
    public ResponseEntity<Vacina> updateVacina(@PathVariable Integer id, @RequestBody Vacina vacinaAtualizada) {
        try {
            Vacina vacina = vacinaService.atualizar(id, vacinaAtualizada);
            return ResponseEntity.ok(vacina);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar vacina
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacina(@PathVariable Integer id) {
        try {
            vacinaService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}