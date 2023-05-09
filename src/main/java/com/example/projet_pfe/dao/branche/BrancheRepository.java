package com.example.projet_pfe.dao.branche;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrancheRepository extends JpaRepository<Branche, Integer> {
    Branche getByCodeBr(Integer codeBr);
}


