package com.company.webapi.impresa.entities;

import com.company.webapi.ditta.entities.Ditta;
import com.company.webapi.ditta.entities.Ditta_;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
		name = "EG_impresaAnnoWithImpresa",
		attributeNodes = @NamedAttributeNode(ImpresaAnno_.IMPRESA)
)
@Entity
public class ImpresaAnno {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "impresaAnno_id_sequence"
	)
	@SequenceGenerator(
			name = "impresaAnno_id_sequence",
			sequenceName = "impresaAnno_id_sequence"
	)
	private Integer id;

	private Integer anno;

	private String ragioneSociale;

	private String pivaCF;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "impresa_id", nullable = false)
	private Impresa impresa;

	@OneToMany(
			mappedBy = Ditta_.IMPRESA_ANNO,
			fetch = FetchType.LAZY,
			cascade = CascadeType.PERSIST
	)
	private List<Ditta> lstDitte;

	public ImpresaAnno() { this.lstDitte = new ArrayList<Ditta>(); }

	public ImpresaAnno(Integer anno, String ragioneSociale, String pivaCF, Impresa impresa) {
		this.anno = anno;
		this.ragioneSociale = ragioneSociale;
		this.pivaCF = pivaCF;
		this.impresa = impresa;

		this.lstDitte = new ArrayList<Ditta>();
	}

	public Integer getId() {
		return id;
	}

	public Integer getAnno() {
		return anno;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public String getPivaCF() {
		return pivaCF;
	}

	public Impresa getImpresa() {
		return this.impresa;
	}

	public void addDitta(Ditta ditta) {
		this.lstDitte.add((ditta));
	}

}