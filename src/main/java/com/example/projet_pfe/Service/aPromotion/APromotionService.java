package com.example.projet_pfe.service.aPromotion;

import com.example.projet_pfe.dao.aPromotion.APromotion;
import com.example.projet_pfe.dao.aPromotion.APromotionRepository;
import com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class APromotionService {

    @Autowired
    private APromotionRepository aPromotionRepository;


    public List<APromotion> findAll() {
        return aPromotionRepository.findAll();
    }

    public APromotion save(APromotion aPromotion) {

        return aPromotionRepository.save(aPromotion);
    }

    public List<RealisationPhysiqueFPS> getRealisationFps(Date du, Date au) {


        return aPromotionRepository.getRealisationPhFPS(du,au);
    }


}


