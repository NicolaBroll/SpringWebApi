package com.company.webapi.ditta.entities;

import com.company.webapi.impresa.entities.ImpresaAnno;
import jakarta.persistence.*;

@NamedEntityGraph(
		name = "ditta-impresaAnno-entity-graph",
		attributeNodes = @NamedAttributeNode(Ditta_.IMPRESA_ANNO)
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

    private String denominazione;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "impresaAnno_id", nullable = false)
    private ImpresaAnno impresaAnno;

    public Ditta() { }

    public Ditta(String denominazione, ImpresaAnno impresaAnno) {
        this.denominazione = denominazione;
        this.impresaAnno = impresaAnno;
    }

    public Integer getId() {
        return id;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public ImpresaAnno getImpresa() {
        return impresaAnno;
    }
}