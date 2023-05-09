package com.example.projet_pfe.service.stagiaire;

import com.example.projet_pfe.dao.stagiaire.Stagiaire;
import com.example.projet_pfe.dao.stagiaire.StagiaireRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StagiaireService {
    @Autowired
    private final StagiaireRepository stagiereRepository;

    public StagiaireService(StagiaireRepository stagiereRepository) {
        this.stagiereRepository = stagiereRepository;
    }
    public List<Stagiaire> findAll(){
        return stagiereRepository.findAll();
    }
    public Stagiaire save(Stagiaire stagiere) {

        return stagiereRepository.save(stagiere);
    }



    }
