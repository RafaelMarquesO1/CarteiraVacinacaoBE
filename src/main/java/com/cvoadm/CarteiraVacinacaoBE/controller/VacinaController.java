package com.cvoadm.CarteiraVacinacaoBE.controller;

import com.cvoadm.CarteiraVacinacaoBE.model.Vacinas;
import com.cvoadm.CarteiraVacinacaoBE.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vacinas")
public class VacinaController {

    @Autowired
    private VacinaService vacinasService;

    // Endpoint para buscar todas as vacinas
    @GetMapping
    public ResponseEntity<List<Vacinas>> getAllVacinas() {
        List<Vacinas> vacinas = vacinasService.findAll();
        return new ResponseEntity<>(vacinas, HttpStatus.OK);
    }

    // Endpoint para buscar vacina por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vacinas> getVacinaById(@PathVariable Long id) {
        Optional<Vacinas> vacina = vacinasService.findById(id);
        return vacina.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint para criar uma nova vacina
    @PostMapping
    public ResponseEntity<Vacinas> createVacina(@RequestBody Vacinas vacina) {
        try {
            Vacinas novaVacina = vacinasService.createVacina(vacina);
            return new ResponseEntity<>(novaVacina, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Endpoint para atualizar uma vacina existente
    @PutMapping("/{id}")
    public ResponseEntity<Vacinas> updateVacina(@PathVariable Long id, @RequestBody Vacinas vacina) {
        try {
            Vacinas vacinaAtualizada = vacinasService.updateVacina(id, vacina);
            return ResponseEntity.ok(vacinaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint para deletar uma vacina
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacina(@PathVariable Long id) {
        try {
            vacinasService.deleteVacina(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
