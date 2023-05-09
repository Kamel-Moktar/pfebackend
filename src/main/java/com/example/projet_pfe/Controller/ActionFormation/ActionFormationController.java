package com.example.projet_pfe.controller.actionFormation;
import com.example.projet_pfe.dao.actionFormation.ActionFormation;
import com.example.projet_pfe.service.actionFormation.ActionFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
    @RestController
    @RequestMapping( "/actionformation")
    public class ActionFormationController {

        private final ActionFormationService actionFormationService;

        @Autowired
        public ActionFormationController(ActionFormationService actionFormationService) {
            this.actionFormationService = actionFormationService;
        }

        @GetMapping("/allactionFormation")
        List<ActionFormation> getAll() {return  actionFormationService.getAllActionF();
        }
        @GetMapping("/recherche/{id}")
       ActionFormation getActionFormationById(@PathVariable Integer codeAct) {
            return actionFormationService.getActionFormationById(codeAct);
        }
        @PostMapping("/add")
        ActionFormation addActionFormation(@RequestBody ActionFormation actionFormation) throws Exception {
            return actionFormationService.addActionFormation(actionFormation);
        }

        @PutMapping ("/update")
       ActionFormation updateActionFormation(@RequestBody ActionFormation actionFormation) throws Exception {
            return actionFormationService.updateActionFormation(actionFormation);
        }
        @DeleteMapping("/delete/{id}")
        void deleteActionFormation(@PathVariable Integer codeAct) throws Exception {

            actionFormationService.deleteActionFormation(codeAct);

        }

    }

