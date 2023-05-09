package com.example.projet_pfe.service.subdivision;

import com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS;
import com.example.projet_pfe.dao.subdivision.Subdivision;
import com.example.projet_pfe.dao.subdivision.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubdivisionService {
    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public SubdivisionService(SubdivisionRepository subdivisionRepository) {
        this.subdivisionRepository = subdivisionRepository;
    }

    public Subdivision save(Subdivision subdivision) {

        return subdivisionRepository.save(subdivision);
    }

    public List<Subdivision> findAll() {
        return subdivisionRepository.findAll();
    }

    public void deleteById(Integer id) {
        System.out.println("Je sui au Service supprimer  subdivsuin ");
        subdivisionRepository.deleteById(id);
    }

    public List<RealisationPhysiqueFPS> getRealisationFps() {

        return subdivisionRepository.getRealisationPhysiqueFPS();
    }

    public Subdivision updateSubdivision(Subdivision subdivision) {
        Subdivision subdivisionOld = subdivisionRepository.getByCodeSub(subdivision.getCodeSub());

        subdivisionOld.setNomSub(subdivision.getNomSub());
        subdivisionOld.setBranches(subdivision.getBranches());

        return subdivisionOld;
    }

}




