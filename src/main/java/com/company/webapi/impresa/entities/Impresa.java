package com.company.webapi.impresa.entities;

import com.company.webapi.ditta.entities.Ditta;
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

//@NamedEntityGraph(
//		name = "impresa-entity-graph",
//		attributeNodes = @NamedAttributeNode(Impresa_.LST_IMPRESA_ANNO)
//
//)
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

	@OneToMany(mappedBy="impresa")
	private List<Ditta> lstDitte;

}