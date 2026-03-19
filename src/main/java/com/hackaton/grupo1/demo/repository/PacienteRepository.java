package com.hackaton.grupo1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.grupo1.demo.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Boolean existsByCpf(String cpf);
}
