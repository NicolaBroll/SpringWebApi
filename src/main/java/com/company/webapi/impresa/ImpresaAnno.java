package com.company.webapi.impresa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private Integer anno;
	private String ragioneSociale;

	@JsonBackReference
	@ManyToOne
	private Impresa impresa;
}