package com.example.projet_pfe.dao.promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {


    Promotion getByCodeProm(Integer codeProm);

    @Query("select new com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS(p.actionFormation.branche.subdivision.nomSub ,count(p.codeProm),0L) from Promotion p " +
            " where p.dateF>= :du  and  p.dateDF<= :au  " +
            " group by p.actionFormation.branche.subdivision.nomSub")
    List<RealisationPhysiqueFPS> getRealisationPhysiqueFPS(@RequestParam Date du, @RequestParam Date au);

}




