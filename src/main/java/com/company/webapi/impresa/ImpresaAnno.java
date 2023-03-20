package com.company.webapi.impresa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ImpresaAnno {

	@Id
	@SequenceGenerator(
			name = "impresaAnno_id_sequence",
			sequenceName = "impresa_id_sequence"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "impresaAnno_id_sequence"
	)
	private Integer id;
	private Impresa impresa;
	private Integer anno;
	private String ragioneSociale;

}