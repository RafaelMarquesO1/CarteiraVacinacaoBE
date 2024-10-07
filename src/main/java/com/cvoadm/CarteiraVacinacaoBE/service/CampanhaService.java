package com.cvoadm.CarteiraVacinacaoBE.service;

import com.cvoadm.CarteiraVacinacaoBE.model.Campanha;
import com.cvoadm.CarteiraVacinacaoBE.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    public List<Campanha> getAllCampanhas() {
        return campanhaRepository.findAll();
    }

    public Optional<Campanha> getCampanhaById(Long id) {
        return campanhaRepository.findById(id);
    }

    public Campanha createCampanha(Campanha campanha) {
        return campanhaRepository.save(campanha);
    }

    public void deleteCampanha(Long id) {
        campanhaRepository.deleteById(id);
    }
}
