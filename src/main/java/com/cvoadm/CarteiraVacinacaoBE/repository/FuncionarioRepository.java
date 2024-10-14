package com.cvoadm.CarteiraVacinacaoBE.repository;

import com.cvoadm.CarteiraVacinacaoBE.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f FROM Funcionario f WHERE f.nome LIKE %:nome%")
    List<Funcionario> findByNome(@Param("nome") String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.email LIKE %:email%")
    List<Funcionario> findByEmail(@Param("email") String email);
}
