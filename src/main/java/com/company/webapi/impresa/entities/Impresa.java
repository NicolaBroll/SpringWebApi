package com.company.webapi.impresa.entities;

import com.company.webapi.ditta.entities.Ditta;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

//@NamedEntityGraph(
//		name = "impresa-entity-graph",
//		attributeNodes = @NamedAttributeNode(Impresa_.LST_IMPRESA_ANNO)
//
//)
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
			cascade = CascadeType.ALL
	)
	private Set<Ditta> lstDitte;

	public Impresa() {
		this.lstDitte = new HashSet<Ditta>(){};
	}

	public Impresa(Integer anno, String ragioneSociale, Boolean isDisattivata, String pivaCF) {
		this.anno = anno;
		this.ragioneSociale = ragioneSociale;
		this.IsDisattivata = isDisattivata;
		this.pivaCF = pivaCF;


		this.lstDitte = new HashSet<Ditta>(){};

	}

	public void addDitta(Ditta ditta) {
		this.lstDitte.add((ditta));
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

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public Boolean getIsDisattivata() {
		return IsDisattivata;
	}

	public void setIsDisattivata(Boolean disattivata) {
		IsDisattivata = disattivata;
	}

	public String getPivaCF() {
		return pivaCF;
	}

	public void setPivaCF(String pivaCF) {
		this.pivaCF = pivaCF;
	}

	public Set<Ditta> getLstDitte() {
		return lstDitte;
	}

	public void setLstDitte(Set<Ditta> lstDitte) {
		this.lstDitte = lstDitte;
	}
}