package com.company.webapi.ditta.entities;

import com.company.webapi.impresa.entities.Impresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ditta {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ditta_id_sequence"
    )
    @SequenceGenerator(
            name = "ditta_id_sequence",
            sequenceName = "ditta_id_sequence"
    )
    private Integer id;

    private Integer anno;

    private String denominazione;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "impresa_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Impresa impresa;
}
