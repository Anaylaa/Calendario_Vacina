package com.hackaton.grupo1.demo.repository;

import com.hackaton.grupo1.demo.entity.Dose;
import com.hackaton.grupo1.demo.enums.PublicoAlvo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.hackaton.grupo1.demo.entity.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Integer> {

    List<Vacina> findByPublicoAlvo(PublicoAlvo publicoAlvo);

    List<Vacina> findByLimiteAplicacaoGreaterThan(int meses);

    long countByLimiteAplicacaoGreaterThan(int meses);

    @Query("SELECT v FROM Vacina v WHERE v.id NOT IN " +
            "(SELECT i.dose.vacina.id FROM Imunizacao i WHERE i.paciente.id = :idPaciente)")
    List<Vacina> findVacinasNaoAplicadas(Integer idPaciente);
}