package com.cvoadm.CarteiraVacinacaoBE.service;

import com.cvoadm.CarteiraVacinacaoBE.model.Paciente;
import com.cvoadm.CarteiraVacinacaoBE.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente findById(Integer id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void delete(Integer id) {
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> findByNome(String nome) {
        return pacienteRepository.findByNome(nome);
    }

    public List<Paciente> findByTelefone(String telefone) {
        return pacienteRepository.findByTelefone(telefone);
    }
}

