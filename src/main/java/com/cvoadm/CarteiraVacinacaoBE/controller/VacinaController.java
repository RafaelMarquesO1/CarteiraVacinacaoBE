package com.cvoadm.CarteiraVacinacaoBE.controller;

import com.cvoadm.CarteiraVacinacaoBE.model.Vacinas;
import com.cvoadm.CarteiraVacinacaoBE.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacinas")
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @GetMapping
    public ResponseEntity<List<Vacinas>> getAllVacinas() {
        List<Vacinas> vacinas = vacinaService.findAll();
        return ResponseEntity.ok(vacinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacinas> getVacinaById(@PathVariable Long id) {
        Vacinas vacina = vacinaService.findById(id);
        if (vacina != null) {
            return ResponseEntity.ok(vacina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Vacinas> createVacina(@RequestBody Vacinas vacina) {
        Vacinas newVacina = vacinaService.save(vacina);
        return ResponseEntity.ok(newVacina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacinas> updateVacina(@PathVariable Long id, @RequestBody Vacinas vacina) {
        Vacinas updatedVacina = vacinaService.findById(id);
        if (updatedVacina != null) {
            updatedVacina.setLote(vacina.getLote());
            updatedVacina.setNomeVacina(vacina.getNomeVacina());
            updatedVacina.setVacStatus(vacina.getVacStatus());
            Vacinas savedVacina = vacinaService.save(updatedVacina);
            return ResponseEntity.ok(savedVacina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacina(@PathVariable Long id) {
        vacinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}