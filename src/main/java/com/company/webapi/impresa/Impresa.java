package com.company.webapi.impresa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Impresa {

	@Id
	@SequenceGenerator(
			name = "impresa_id_sequence",
			sequenceName = "impresa_id_sequence"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "impresa_id_sequence"
	)
	private Integer id;
	private String codice;
	private Boolean isActive;
	@OneToMany(
			mappedBy = "impresa",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<ImpresaAnno> lstImpresaAnno = new ArrayList<>();
}