package com.cvoadm.CarteiraVacinacaoBE.controller;

import com.cvoadm.CarteiraVacinacaoBE.model.Campanha;
import com.cvoadm.CarteiraVacinacaoBE.service.CampanhaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/campanhas")
public class CampanhaController {

    private static final Logger logger = LoggerFactory.getLogger(CampanhaController.class);

    @Autowired
    private CampanhaService campanhaService;

    @GetMapping
    public ResponseEntity<List<Campanha>> getAllCampanhas() {
        List<Campanha> campanhas = campanhaService.getAllCampanhas();
        return ResponseEntity.ok(campanhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campanha> getCampanhaById(@PathVariable Long id) {
        Optional<Campanha> campanha = campanhaService.getCampanhaById(id);
        return campanha.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<String> createCampanha(
            @RequestParam("nomeCampanha") String nomeCampanha,
            @RequestParam("descricao") String descricao,
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
            @RequestParam(value = "imagemUrl", required = false) MultipartFile imagemUrl) {

        String imagePath = null;

        try {
            if (imagemUrl != null && !imagemUrl.isEmpty()) {
                // Crie o diretório se ele não existir
                File uploadDir = new File("uploads");
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                imagePath = "uploads/" + imagemUrl.getOriginalFilename();
                File file = new File(imagePath);
                imagemUrl.transferTo(file);
            }

            Campanha novaCampanha = new Campanha(nomeCampanha, descricao, dataInicio, dataFim, imagePath);
            Campanha campanhaSalva = campanhaService.createCampanha(novaCampanha);

            return new ResponseEntity<>("Campanha criada com sucesso: " + campanhaSalva.getId(), HttpStatus.CREATED);
        } catch (IOException e) {
            logger.error("Erro ao salvar a imagem: {}", e.getMessage());
            return new ResponseEntity<>("Erro ao salvar a imagem: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            logger.error("Erro ao criar a campanha: {}", e.getMessage());
            return new ResponseEntity<>("Erro ao criar a campanha: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampanha(@PathVariable Long id) {
        try {
            campanhaService.deleteCampanha(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar a campanha com ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
