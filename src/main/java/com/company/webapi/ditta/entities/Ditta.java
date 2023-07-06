package com.company.webapi.ditta.entities;

import com.company.webapi.impresa.entities.Impresa;
import jakarta.persistence.*;

@NamedEntityGraph(
		name = "ditta-impresa-entity-graph",
		attributeNodes = @NamedAttributeNode(Ditta_.IMPRESA)
)
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

    public Ditta(Integer anno, String denominazione, Impresa impresa) {
        this.anno = anno;
        this.denominazione = denominazione;
        this.impresa = impresa;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAnno() {
        return anno;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public Impresa getImpresa() {
        return impresa;
    }

}
