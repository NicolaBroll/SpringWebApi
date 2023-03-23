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
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "impresaAnno_id_sequence"
	)
	@SequenceGenerator(
			name = "impresaAnno_id_sequence",
			sequenceName = "impresaAnno_id_sequence",
			allocationSize = 1
	)
	private Integer id;
	private Integer anno;
	private String ragioneSociale;
}