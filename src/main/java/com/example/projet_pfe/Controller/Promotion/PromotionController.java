package com.example.projet_pfe.controller.promotion;

import com.example.projet_pfe.dao.promotion.Promotion;
import com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS;
import com.example.projet_pfe.service.promotion.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {
    private final PromotionService promotionService;
    @Autowired

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/all")
    public List<Promotion> getAllPromotions() {

        return promotionService.findAll();
    }

        @GetMapping("/realisationfps/{du}/{au}")
    public List<RealisationPhysiqueFPS> getRealisationFps(@PathVariable String du, @PathVariable String au) {

        Date dd=new Date();
        Date df=new Date();

        try {
           dd= new SimpleDateFormat("yyyy-MM-dd").parse(du);
           df= new SimpleDateFormat("yyyy-MM-dd").parse(au);
       }catch (Exception e){};

        return promotionService.getRealisationFps(dd,df);
    }

    @PostMapping("/add")
    public Promotion createPromotion(@RequestBody Promotion promotion) {

        return promotionService.save(promotion);
    }
    @PutMapping("/update")
    public Promotion updatePromotion(@RequestBody Promotion promotion) {
        return promotionService.updatePromotion(promotion);
    }
        @DeleteMapping("/delete/{id}")
        public void deletePromotion(@PathVariable Integer id) {
            promotionService.deleteById(id);
        }
 }



