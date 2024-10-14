package com.cvoadm.CarteiraVacinacaoBE.repository;

import com.cvoadm.CarteiraVacinacaoBE.model.Vacinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VacinasRepository extends JpaRepository<Vacinas, Long> {

    @Query("SELECT v FROM Vacinas v WHERE v.nomeVacina LIKE %:nomeVacina%")
    List<Vacinas> findByNomeVacina(@Param("nomeVacina") String nomeVacina );

    @Query("SELECT v FROM Vacinas v WHERE v.lote LIKE %:lote%")
    List<Vacinas> findByLote(@Param("lote") String lote);
}