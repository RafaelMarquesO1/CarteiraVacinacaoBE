package com.cvoadm.CarteiraVacinacaoBE.repository;

import com.cvoadm.CarteiraVacinacaoBE.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query("SELECT p FROM Paciente p WHERE p.nome LIKE %:nome%")
    List<Paciente> findByNome(@Param("nome") String nome);

    @Query("SELECT p FROM Paciente p WHERE p.telefone LIKE %:telefone%")
    List<Paciente> findByTelefone(@Param("telefone") String telefone);
}
