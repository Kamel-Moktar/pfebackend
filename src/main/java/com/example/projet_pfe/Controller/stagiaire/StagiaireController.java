package com.example.projet_pfe.controller.stagiaire;

import com.example.projet_pfe.dao.stagiaire.Stagiaire;
import com.example.projet_pfe.service.stagiaire.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/stagiaire")
public class StagiaireController {
    private final StagiaireService stagiaireService;

    @Autowired
    public StagiaireController(StagiaireService stagiaireService) {
        this.stagiaireService = stagiaireService;
    }

    @GetMapping("/all")
    public List<Stagiaire> getAllStagiere() {

        return stagiaireService.findAll();
    }

    @PostMapping("/add")
    public Stagiaire createStagiere(@RequestBody Stagiaire stagiaire) {

        return stagiaireService.save(stagiaire);
    }
}