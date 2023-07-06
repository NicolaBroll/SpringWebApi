package com.company.webapi.ditta.entities;

import com.company.webapi.impresa.entities.Impresa;
import jakarta.persistence.*;

@Entity
public class Ditta {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ditta_id_sequence"
    )
    @SequenceGenerator(
            name = "ditta_id_sequence",
            sequenceName = "ditta_id_sequence"
    )
    private Integer id;

    private Integer anno;

    private String denominazione;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "impresa_id", nullable = false)
    private Impresa impresa;

    public Ditta() {
    }

    public Ditta(Integer anno, String denominazione) {
        this.anno = anno;
        this.denominazione = denominazione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public Impresa getImpresa() {
        return impresa;
    }

    public void setImpresa(Impresa impresa) {
        this.impresa = impresa;
    }
}
