package com.cvoadm.CarteiraVacinacaoBE.controller;

import com.cvoadm.CarteiraVacinacaoBE.model.Funcionario;
import com.cvoadm.CarteiraVacinacaoBE.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Integer id) {
        Funcionario funcionario = funcionarioService.findById(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario newFuncionario = funcionarioService.save(funcionario);
        return ResponseEntity.ok(newFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
        Funcionario updatedFuncionario = funcionarioService.findById(id);
        if (updatedFuncionario != null) {
            updatedFuncionario.setNome(funcionario.getNome());
            updatedFuncionario.setEmail(funcionario.getEmail());
            updatedFuncionario.setSenha(funcionario.getSenha());
            Funcionario savedFuncionario = funcionarioService.save(updatedFuncionario);
            return ResponseEntity.ok(savedFuncionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Integer id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
