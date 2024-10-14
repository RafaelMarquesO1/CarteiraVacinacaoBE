package com.cvoadm.CarteiraVacinacaoBE.repository;

import com.cvoadm.CarteiraVacinacaoBE.model.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

    @Query("SELECT c FROM Campanha c WHERE c.nomeCampanha LIKE %:nomeCampanha%")
    List<Campanha> findByNomeCampanha(@Param("nomeCampanha") String nomeCampanha);

    @Query("SELECT c FROM Campanha c WHERE c.descricao LIKE %:descricao%")
    List<Campanha> findByDescricao(@Param("descricao") String descricao);

    @Query("SELECT c FROM Campanha c WHERE c.dataInicio = :dataInicio")
    List<Campanha> findByDataInicio(@Param("dataInicio") LocalDate dataInicio);

    @Query("SELECT c FROM Campanha c WHERE c.dataFim = :dataFim")
    List<Campanha> findByDataFim(@Param("dataFim") LocalDate dataFim);
}

