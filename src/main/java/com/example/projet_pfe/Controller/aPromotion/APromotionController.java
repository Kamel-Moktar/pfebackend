package com.example.projet_pfe.controller.aPromotion;

import com.example.projet_pfe.dao.aPromotion.APromotion;
import com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS;
import com.example.projet_pfe.service.aPromotion.APromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/A_promotion")
public class APromotionController {


    @Autowired
    private APromotionService aPromotionService;


    @GetMapping("/all")
    public List<APromotion> getAllStagiaire() {

        return aPromotionService.findAll();
    }

    @PostMapping("/add")
    public APromotion createA_promotion(@RequestBody APromotion a_promotion) {

        return aPromotionService.save(a_promotion);
    }

    @GetMapping("/realisationfps/{du}/{au}")
    public List<RealisationPhysiqueFPS> getRealisationFps(@PathVariable String du, @PathVariable String au) {

        Date dd=new Date();
        Date df=new Date();

        try {
            dd= new SimpleDateFormat("yyyy-MM-dd").parse(du);
            df= new SimpleDateFormat("yyyy-MM-dd").parse(au);
        }catch (Exception e){};

        return null;
    }



}
