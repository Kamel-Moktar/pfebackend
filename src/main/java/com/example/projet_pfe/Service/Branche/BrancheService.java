package com.example.projet_pfe.service.branche;

import com.example.projet_pfe.dao.branche.Branche;
import com.example.projet_pfe.dao.branche.BrancheRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BrancheService {
    @Autowired
    BrancheRepository brancheRepository;

    public Branche save(Branche branche) {
        return brancheRepository.save(branche);
    }

    public List<Branche> findAll() {
        return brancheRepository.findAll();
    }
    public Branche updateBranche(Branche branche) {
            Branche brancheOld=brancheRepository.getByCodeBr(branche.getCodeBr());
        brancheOld.setCodeBr(branche.getCodeBr());
        brancheOld.setCouleur(branche.getCouleur());
        brancheOld.setCodeDom(branche.getCodeDom());
        brancheOld.setDesignBr(branche.getDesignBr());
        brancheOld.setImput(branche.getImput());

            return brancheOld;
        }

    public void deleteById(Integer id) {
        brancheRepository.deleteById(id);
    }
}



