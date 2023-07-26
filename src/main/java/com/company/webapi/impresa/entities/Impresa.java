package com.company.webapi.impresa.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Impresa {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "impresa_id_sequence"
	)
	@SequenceGenerator(
			name = "impresa_id_sequence",
			sequenceName = "impresa_id_sequence"
	)
	private Integer id;

	private String chiave;

	@OneToMany(
			mappedBy = ImpresaAnno_.IMPRESA,
			fetch = FetchType.LAZY,
			cascade = CascadeType.PERSIST
	)
	private List<ImpresaAnno> lstImpresaAnno;

	public Impresa() {
		this.lstImpresaAnno = new ArrayList<ImpresaAnno>();
	}

	public Impresa(String chiave) {
		this.chiave = chiave;
		this.lstImpresaAnno = new ArrayList<ImpresaAnno>();
	}

	public void addImpresaAnno(ImpresaAnno impresaAnno) {
		this.lstImpresaAnno.add((impresaAnno));
	}

	public Integer getId() {
		return id;
	}

	public String getChiave() {
		return this.chiave;
	}

	public List<ImpresaAnno> getListaImpresaAnno() {
		return this.lstImpresaAnno;
	}
}