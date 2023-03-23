package com.company.webapi.impresa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Impresa {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "impresa_id_sequence"
	)
	@SequenceGenerator(
			name = "impresa_id_sequence",
			sequenceName = "impresa_id_sequence",
			allocationSize = 1
	)
	private Integer id;
	//private String codice;
	private Boolean isActive;
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@JoinColumn(
			name = "impresa_id"
	)
	private List<ImpresaAnno> lstImpresaAnno;

}