package com.cvoadm.CarteiraVacinacaoBE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vacinas")
public class Vacinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lote") // Verifique se o nome da coluna está correto
    private String lote;

    @Column(name = "nomeVacina") // Certifique-se de que o nome está correto
    private String nomeVacina;

    @Column(name = "vacStatus") // Verifique se o nome da coluna está correto
    private String vacStatus;

    // Getters e setters
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
