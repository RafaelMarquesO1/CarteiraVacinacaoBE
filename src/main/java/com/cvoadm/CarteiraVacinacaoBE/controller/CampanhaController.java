package com.cvoadm.CarteiraVacinacaoBE.controller;

import com.cvoadm.CarteiraVacinacaoBE.model.Campanha;
import com.cvoadm.CarteiraVacinacaoBE.service.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campanhas")
public class CampanhaController {

    @Autowired
    private CampanhaService campanhaService;

    @GetMapping
    public ResponseEntity<List<Campanha>> getAllCampanhas() {
        List<Campanha> campanhas = campanhaService.findAll();
        return ResponseEntity.ok(campanhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campanha> getCampanhaById(@PathVariable Long id) {
        Campanha campanha = campanhaService.findById(id);
        if (campanha != null) {
            return ResponseEntity.ok(campanha);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Campanha> createCampanha(@RequestBody Campanha campanha) {
        Campanha newCampanha = campanhaService.save(campanha);
        return ResponseEntity.ok(newCampanha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campanha> updateCampanha(@PathVariable Long id, @RequestBody Campanha campanha) {
        Campanha updatedCampanha = campanhaService.findById(id);
        if (updatedCampanha != null) {
            updatedCampanha.setNomeCampanha(campanha.getNomeCampanha());
            updatedCampanha.setDescricao(campanha.getDescricao());
            updatedCampanha.setDataInicio(campanha.getDataInicio());
            updatedCampanha.setDataFim(campanha.getDataFim());
            Campanha savedCampanha = campanhaService.save(updatedCampanha);
            return ResponseEntity.ok(savedCampanha);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampanha(@PathVariable Long id) {
        campanhaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
