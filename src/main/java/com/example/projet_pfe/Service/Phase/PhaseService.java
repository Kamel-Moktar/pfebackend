package com.example.projet_pfe.service.phase;

import com.example.projet_pfe.dao.phase.Phase;
import com.example.projet_pfe.dao.phase.PhaseRepository;
import com.example.projet_pfe.service.promotion.PromotionDuree;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Service
@Transactional
public class PhaseService {

    @Autowired
    private final PhaseRepository phaseRepository;

    public PhaseService(PhaseRepository phaseRepository) {
        this.phaseRepository = phaseRepository;
    }

    public List<Phase> findAll() {
        return phaseRepository.findAll();
    }

    public Phase save(Phase phase) {

        return phaseRepository.save(phase);
    }

    public List<Phase> getPhaseBetweenDates(Date du, Date au) {
        List<Phase> phases = phaseRepository.getPhaseBetweenDates(du, au);
        List<PromotionDuree> promotionDurees = new LinkedList<PromotionDuree>();
        phases.forEach(e->{
            System.out.println(e.getPromotion().getLibPromo());
            PromotionDuree promotionDuree = new PromotionDuree();
            promotionDuree.setPromotion(e.getPromotion());

            if ((e.getDateD().compareTo(du) <= 0) )  promotionDuree.setDateD(e.getDateD());
            else   promotionDuree.setDateD(du);

            if (e.getDateF().compareTo(au)  <= 0)  promotionDuree.setDateF(au);
            else  promotionDuree.setDateF(e.getDateF());

            long duree=promotionDuree.getDateF().getTime()-promotionDuree.getDateD().getTime();
            long d=(duree/(1000*60*60*24)/7)*5;



            promotionDuree.setDurree(d);
             promotionDurees.add(promotionDuree);
        });

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
     promotionDurees.forEach(e -> System.out.println("code_prom=" + e.getPromotion().getLibPromo() + "dd=" + e.getDateD() + "df="+e.getDateF()+"duree="+e.getDurree() ));
        System.out.println("#########################################################################");
        return null;
//        phaseRepository.getPhaseBetweenDates(du, au);
    }
}


