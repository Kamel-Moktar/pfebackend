package com.example.projet_pfe.dao.phase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Integer> {

    @Query("select p from Phase  p "  +
            " where p.dateF>= :du  and  p.dateD<= :au  " )

    List<Phase> getPhaseBetweenDates(@RequestParam Date du, @RequestParam Date au) ;

}
