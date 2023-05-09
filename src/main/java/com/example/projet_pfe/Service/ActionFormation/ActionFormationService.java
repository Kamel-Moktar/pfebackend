package com.example.projet_pfe.service.actionFormation;

import com.example.projet_pfe.dao.actionFormation.ActionFormation;
import com.example.projet_pfe.dao.actionFormation.ActionFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ActionFormationService {
    @Autowired
    public ActionFormationRepository actionFormationRepository;
    public List<ActionFormation> getAllActionF() {
        return actionFormationRepository.findAll();
    }

    public ActionFormation getActionFormationById(Integer codeAct) {
        return actionFormationRepository.findActionFormationByCodeAct(codeAct);
    }
    public ActionFormation addActionFormation(ActionFormation actionFormation) {
        return actionFormationRepository.save(actionFormation);
    }
    public ActionFormation updateActionFormation(ActionFormation actionFormation) {
        ActionFormation actionFormationOld=actionFormationRepository.findActionFormationByCodeAct(actionFormation.getCodeAct());

        actionFormationOld.setLibForm(actionFormation.getLibForm());
        actionFormationOld.setBranche(actionFormation.getBranche());
        actionFormationOld.setCodeActI(actionFormation.getCodeActI());
        actionFormationOld.setDuree(actionFormation.getDuree());
        actionFormationOld.setButForm(actionFormation.getButForm());
        actionFormationOld.setCouleur(actionFormation.getCouleur());
        actionFormationOld.setTypeHoraire(actionFormation.getTypeHoraire());
        actionFormationOld.setGsp(actionFormation.getGsp());
        actionFormationOld.setCodeFiche(actionFormation.getCodeFiche());


        return actionFormationOld;
    }
    public void deleteActionFormation(Integer codeAct) throws Exception {
        ActionFormation actionFormation = actionFormationRepository.findActionFormationByCodeAct(codeAct);
        actionFormationRepository.delete(actionFormation);
    }
}










