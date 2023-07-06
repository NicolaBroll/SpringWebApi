package com.company.webapi.impresa.entities;

import com.company.webapi.ditta.entities.Ditta;
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

	private Integer anno;

	private String ragioneSociale;

	private Boolean IsDisattivata;

	private String pivaCF;

	@OneToMany(
			mappedBy = "impresa",
			fetch = FetchType.LAZY,
			cascade = CascadeType.PERSIST
	)
	private List<Ditta> lstDitte;

	public Impresa() {
		this.lstDitte = new ArrayList<Ditta>(){};
	}

	public Impresa(Integer anno, String ragioneSociale, Boolean isDisattivata, String pivaCF) {
		this.anno = anno;
		this.ragioneSociale = ragioneSociale;
		this.IsDisattivata = isDisattivata;
		this.pivaCF = pivaCF;


		this.lstDitte = new ArrayList<Ditta>(){};

	}

	public void addDitta(Ditta ditta) {
		this.lstDitte.add((ditta));
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

	public Boolean getIsDisattivata() {
		return IsDisattivata;
	}

	public String getPivaCF() {
		return pivaCF;
	}
}