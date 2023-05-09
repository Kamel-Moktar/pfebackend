package com.example.projet_pfe.controller.phase;

import com.example.projet_pfe.dao.phase.Phase;
import com.example.projet_pfe.service.phase.PhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/phase")
public class PhaseController {
        private final PhaseService phaseService;

        @Autowired
        public PhaseController(PhaseService phaseService) {
            this.phaseService = phaseService;
        }

        @GetMapping("/all")
        public List<Phase> getAllPhase() {

            return phaseService.findAll();
        }

        @PostMapping("/add")
        public Phase createPhase(@RequestBody Phase phase) {

            return phaseService.save(phase);
        }

        @GetMapping("/phase_between_dates/{du}/{au}")
        public List<Phase> getphaseBetweenDtaes(@PathVariable String du, @PathVariable String au){
            Date dd=new Date();
            Date df=new Date();

            try {
                dd= new SimpleDateFormat("yyyy-MM-dd").parse(du);
                df= new SimpleDateFormat("yyyy-MM-dd").parse(au);
            }catch (Exception e){
                //traitemment de l'excepetion
            };

           phaseService.getPhaseBetweenDates(dd,df);
            return null;

        }
    }

