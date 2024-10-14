package com.cvoadm.CarteiraVacinacaoBE.controller;

import com.cvoadm.CarteiraVacinacaoBE.model.Paciente;
import com.cvoadm.CarteiraVacinacaoBE.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        List<Paciente> pacientes = pacienteService.findAll();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Integer id) {
        Paciente paciente = pacienteService.findById(id);
        if (paciente != null) {
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente newPaciente = pacienteService.save(paciente);
        return ResponseEntity.ok(newPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Integer id, @RequestBody Paciente paciente) {
        Paciente updatedPaciente = pacienteService.findById(id);
        if (updatedPaciente != null) {
            updatedPaciente.setNome(paciente.getNome());
            updatedPaciente.setTelefone(paciente.getTelefone());
            updatedPaciente.setGenero(paciente.getGenero());
            updatedPaciente.setDataNasc(paciente.getDataNasc());
            updatedPaciente.setEndereco(paciente.getEndereco());
            updatedPaciente.setCpf(paciente.getCpf());
            Paciente savedPaciente = pacienteService.save(updatedPaciente);
            return ResponseEntity.ok(savedPaciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Integer id) {
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}