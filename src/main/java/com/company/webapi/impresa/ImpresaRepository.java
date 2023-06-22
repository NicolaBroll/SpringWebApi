package com.company.webapi.impresa;

import com.company.webapi.impresa.entities.Impresa;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ImpresaRepository extends JpaRepository<Impresa, Integer>, JpaSpecificationExecutor<Impresa> {
    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {
                    "lstImpresaAnno"
            }
    )
    List<Impresa> findAllNew();

}