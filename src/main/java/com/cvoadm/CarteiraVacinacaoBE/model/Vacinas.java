package com.cvoadm.CarteiraVacinacaoBE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Vacinas")
public class Vacinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lote;

    private String nomeVacina;

    private String vacStatus;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getVacStatus() {
        return vacStatus;
    }

    public void setVacStatus(String vacStatus) {
        this.vacStatus = vacStatus;
    }
}
