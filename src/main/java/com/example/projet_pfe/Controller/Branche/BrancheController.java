package com.example.projet_pfe.controller.branche;


import com.example.projet_pfe.dao.branche.Branche;
import com.example.projet_pfe.service.branche.BrancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/branche")
    public class BrancheController {
        private final BrancheService brancheService;
        @Autowired
        public BrancheController(BrancheService brancheService) {
            this.brancheService = brancheService;
        }
        @GetMapping("/allbranche")
        public List<Branche> getAllBranches() {

            return brancheService.findAll();
        }

        @PostMapping("/add")
        Branche addBranche(@RequestBody Branche branche)  {
            return brancheService.save(branche);
        }

        @PutMapping ("/update")
        Branche updateBranche(@RequestBody Branche branche){
            return brancheService.updateBranche(branche);
        }

        @DeleteMapping("/delete/{id}")
       public void deleteBranche(@PathVariable Integer id) {

            brancheService.deleteById(id);


            }
        }
