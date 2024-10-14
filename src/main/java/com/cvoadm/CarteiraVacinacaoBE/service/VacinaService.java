package com.cvoadm.CarteiraVacinacaoBE.service;

import com.cvoadm.CarteiraVacinacaoBE.model.Vacinas;
import com.cvoadm.CarteiraVacinacaoBE.repository.VacinasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VacinaService {

    @Autowired
    private VacinasRepository vacinasRepository;

    public List<Vacinas> findAll() {
        return vacinasRepository.findAll();
    }

    public Vacinas findById(Long id) {
        return vacinasRepository.findById(id).orElse(null);
    }

    public Vacinas save(Vacinas vacinas) {
        return vacinasRepository.save(vacinas);
    }

    public void delete(Long id) {
        vacinasRepository.deleteById(id);
    }

    public List<Vacinas> findByNomeVacina(String nomeVacina) {
        return vacinasRepository.findByNomeVacina(nomeVacina);
    }

    public List<Vacinas> findByLote(String lote) {
        return vacinasRepository.findByLote(lote);
    }
}
