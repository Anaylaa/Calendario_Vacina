package com.hackaton.grupo1.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackaton.grupo1.demo.entity.Vacina;
import com.hackaton.grupo1.demo.repository.VacinaRepository;

@Service
public class VacinaService {

    private final VacinaRepository vacinaRepository;

    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    // 🔹 Criar vacina
    public Vacina salvar(Vacina vacina) {

        // validação simples (evitar nome duplicado)
        Optional<Vacina> vacinaExistente = vacinaRepository.findByNome(vacina.getNome());
        if (vacinaExistente.isPresent()) {
            throw new RuntimeException("Já existe uma vacina com esse nome");
        }

        return vacinaRepository.save(vacina);
    }

    // 🔹 Listar todas
    public List<Vacina> listarTodas() {
        return vacinaRepository.findAll();
    }

    // 🔹 Buscar por ID
    public Vacina buscarPorId(Integer id) {
        return vacinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacina não encontrada com ID: " + id));
    }

    // 🔹 Atualizar vacina
    public Vacina atualizar(Integer id, Vacina vacinaAtualizada) {

        Vacina vacina = buscarPorId(id);

        vacina.setNome(vacinaAtualizada.getNome());
        vacina.setDescricao(vacinaAtualizada.getDescricao());
        vacina.setLimiteAplicacao(vacinaAtualizada.getLimiteAplicacao());
        vacina.setPublicoAlvo(vacinaAtualizada.getPublicoAlvo());

        return vacinaRepository.save(vacina);
    }

    // 🔹 Deletar vacina
    public void deletar(Integer id) {

        Vacina vacina = buscarPorId(id);
        vacinaRepository.delete(vacina);
    }
}
