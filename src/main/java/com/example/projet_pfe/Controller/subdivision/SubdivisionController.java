package com.example.projet_pfe.controller.subdivision;

import com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS;
import com.example.projet_pfe.dao.subdivision.Subdivision;
import com.example.projet_pfe.service.subdivision.SubdivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping( "/subdivision")
    public class SubdivisionController {

        private final SubdivisionService subdivisionService;

        @Autowired
        public SubdivisionController(SubdivisionService subdivisionService) {
            this.subdivisionService = subdivisionService;
        }

        @GetMapping("/all")
        public List<Subdivision> getAllSubdivisions() {

            return subdivisionService.findAll();
        }

        @GetMapping("/realisationfps")
        public List<RealisationPhysiqueFPS> getRealisationFps() {
            return subdivisionService.getRealisationFps();
        }

        @PostMapping("/add")
        public Subdivision createSubdivision(@RequestBody Subdivision subdivision) {
            return subdivisionService.save(subdivision);
        }

        @PutMapping("/update")
        public Subdivision updateSubdivision(@RequestBody Subdivision subdivision) {
            return subdivisionService.updateSubdivision(subdivision);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteSubdivision(@PathVariable Integer id) {
              System.out.println("Je sui au controleur supprimer subdivsuin ");
             subdivisionService.deleteById(id);
        }
    }


