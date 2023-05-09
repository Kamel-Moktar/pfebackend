package com.example.projet_pfe.service.promotion;

import com.example.projet_pfe.dao.promotion.Promotion;
import com.example.projet_pfe.dao.promotion.PromotionRepository;
import com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS;
import com.example.projet_pfe.service.aPromotion.APromotionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    APromotionService aPromotionService;

    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    public Promotion save(Promotion promotion) {

        return promotionRepository.save(promotion);
    }

    public void deleteById(Integer id) {

        promotionRepository.deleteById(id);
    }

    public Promotion updatePromotion(Promotion promotion) {
        Promotion promotionOld = promotionRepository.getByCodeProm(promotion.getCodeProm());

        promotionOld.setCodePhaExam(promotion.getCodePhaExam());
        promotionOld.setCodeProm3(promotion.getCodeProm3());
        promotionOld.setCodeResp(promotion.getCodeResp());
        promotionOld.setCoefPhaExam(promotion.getCoefPhaExam());
        promotionOld.setActionFormation(promotion.getActionFormation());
        promotionOld.setLibPromo(promotion.getLibPromo());
        promotionOld.setDateDF(promotion.getDateDF());
        promotionOld.setDateFPrev(promotion.getDateFPrev());
        promotionOld.setDateJury(promotion.getDateJury());
        promotionOld.setDateRetour(promotion.getDateRetour());
        promotionOld.setDateF(promotion.getDateF());
        promotionOld.setNbEquipe(promotion.getNbEquipe());
        promotionOld.setNbStag(promotion.getNbStag());
        promotionOld.setTypeHoraire(promotion.getTypeHoraire());
        promotionOld.setImputation(promotion.getImputation());

        return promotionOld;
    }


    public List<RealisationPhysiqueFPS> getRealisationFps(Date du, Date au) {

        List<RealisationPhysiqueFPS> realisationPhysiqueFPS1 = promotionRepository.getRealisationPhysiqueFPS(du, au);
        List<RealisationPhysiqueFPS> realisationPhysiqueFPS2 = aPromotionService.getRealisationFps(du, au);

        realisationPhysiqueFPS1.forEach(r -> {
            realisationPhysiqueFPS2.forEach(r2 -> {
                if (r.getNomSub().equals(r2.getNomSub())) r.setEffectif(r2.getEffectif());
            });
        });


        return realisationPhysiqueFPS1;
    }


}

