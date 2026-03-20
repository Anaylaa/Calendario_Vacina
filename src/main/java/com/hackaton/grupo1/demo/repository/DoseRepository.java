package com.hackaton.grupo1.demo.repository;

import com.hackaton.grupo1.demo.entity.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose, Integer> {
}
