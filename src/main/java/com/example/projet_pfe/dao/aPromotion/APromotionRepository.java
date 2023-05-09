package com.example.projet_pfe.dao.aPromotion;

import com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Repository
public interface APromotionRepository extends JpaRepository<APromotion, Integer> {


   @Query("select new com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS(p.promotion.actionFormation.branche.subdivision.nomSub ,0L,count(p.stagiaire)) from APromotion  p " +
           " where p.promotion.dateF>= :du  and  p.promotion.dateDF<= :au  " +
           " group by p.promotion.actionFormation.branche.subdivision.nomSub")
   List<RealisationPhysiqueFPS> getRealisationPhFPS(@RequestParam Date du, @RequestParam Date au);

    @Query("select new com.example.projet_pfe.dao.aPromotion.EffectifByPromotion(p.promotion ,count(p.stagiaire)) from APromotion  p " +
            " group by p.promotion")
    List<EffectifByPromotion> getEffectifByPromotion();

}
