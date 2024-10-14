package com.cvoadm.CarteiraVacinacaoBE.service;

import com.cvoadm.CarteiraVacinacaoBE.model.Funcionario;
import com.cvoadm.CarteiraVacinacaoBE.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Integer id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void delete(Integer id) {
        funcionarioRepository.deleteById(id);
    }

    public List<Funcionario> findByNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    public List<Funcionario> findByEmail(String email) {
        return funcionarioRepository.findByEmail(email);
    }
}
