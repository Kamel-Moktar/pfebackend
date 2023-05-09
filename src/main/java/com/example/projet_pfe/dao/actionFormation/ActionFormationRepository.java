package com.example.projet_pfe.dao.actionFormation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionFormationRepository extends JpaRepository<ActionFormation, Integer> {
    List<ActionFormation> findAll();
    ActionFormation findActionFormationByCodeAct(Integer codeAct);
}

