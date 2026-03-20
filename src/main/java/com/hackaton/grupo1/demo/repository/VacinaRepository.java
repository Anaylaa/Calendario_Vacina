package com.hackaton.grupo1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.hackaton.grupo1.demo.entity.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Integer> {
Optional<Vacina> findByNome(String nome);
    
    
}