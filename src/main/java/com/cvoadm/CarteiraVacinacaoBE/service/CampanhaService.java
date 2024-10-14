package com.cvoadm.CarteiraVacinacaoBE.service;

import com.cvoadm.CarteiraVacinacaoBE.model.Campanha;
import com.cvoadm.CarteiraVacinacaoBE.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    public List<Campanha> findAll() {
        return campanhaRepository.findAll();
    }

    public Campanha findById(Long id) {
        return campanhaRepository.findById(id).orElse(null);
    }

    public Campanha save(Campanha campanha) {
        return campanhaRepository.save(campanha);
    }

    public void delete(Long id) {
        campanhaRepository.deleteById(id);
    }

    public List<Campanha> findByNomeCampanha(String nomeCampanha) {
        return campanhaRepository.findByNomeCampanha(nomeCampanha);
    }

    public List<Campanha> findByDescricao(String descricao) {
        return campanhaRepository.findByDescricao(descricao);
    }

    public List<Campanha> findByDataInicio(LocalDate dataInicio) {
        return campanhaRepository.findByDataInicio(dataInicio);
    }

    public List<Campanha> findByDataFim(LocalDate dataFim) {
        return campanhaRepository.findByDataFim(dataFim);
    }
}
