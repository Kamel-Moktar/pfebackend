package com.example.projet_pfe.dao.stagiaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    @Repository
    public interface StagiaireRepository extends JpaRepository<Stagiaire, Integer> {

        Stagiaire getByCodeUnit(Integer codeUnit);
    }

