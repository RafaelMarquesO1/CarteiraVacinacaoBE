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

    // Método para buscar todas as vacinas
    public List<Vacinas> findAll() {
        return vacinasRepository.findAll();
    }

    // Método para buscar vacina por ID
    public Optional<Vacinas> findById(Long id) {
        return vacinasRepository.findById(id);
    }

    // Método para criar uma nova vacina
    @Transactional
    public Vacinas createVacina(Vacinas vacina) throws Exception {
        validateVacina(vacina); // Valida os dados da vacina antes de criar
        return vacinasRepository.save(vacina);
    }

    // Método para atualizar uma vacina existente
    @Transactional
    public Vacinas updateVacina(Long id, Vacinas vacinaAtualizada) throws Exception {
        Optional<Vacinas> vacinaExistente = vacinasRepository.findById(id);
        if (vacinaExistente.isPresent()) {
            Vacinas vacina = vacinaExistente.get();
            // Atualizando os dados
            vacina.setNomeVacina(vacinaAtualizada.getNomeVacina());
            vacina.setLote(vacinaAtualizada.getLote());
            vacina.setVacStatus(vacinaAtualizada.getVacStatus());

            validateVacina(vacina); // Valida os dados da vacina antes de atualizar
            return vacinasRepository.save(vacina); // Salva a vacina atualizada
        } else {
            throw new Exception("Vacina com o ID " + id + " não encontrada.");
        }
    }

    // Método para deletar uma vacina
    @Transactional
    public void deleteVacina(Long id) throws Exception {
        Optional<Vacinas> vacinaExistente = vacinasRepository.findById(id);
        if (vacinaExistente.isPresent()) {
            vacinasRepository.delete(vacinaExistente.get());
        } else {
            throw new Exception("Vacina com o ID " + id + " não encontrada.");
        }
    }

    // Validação dos dados da vacina
    private void validateVacina(Vacinas vacina) throws Exception {
        if (vacina.getNomeVacina() == null || vacina.getNomeVacina().isEmpty()) {
            throw new Exception("O nome da vacina é obrigatório.");
        }
        if (vacina.getLote() == null || vacina.getLote().isEmpty()) {
            throw new Exception("O lote da vacina é obrigatório.");
        }
        if (vacina.getVacStatus() == null || vacina.getVacStatus().isEmpty()) {
            throw new Exception("O status da vacina é obrigatório (ATIVO/INATIVO).");
        }
    }
}
