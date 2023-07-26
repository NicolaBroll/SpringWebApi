package com.company.webapi.ditta;

import com.company.webapi.ditta.entities.Ditta;
import com.company.webapi.impresa.entities.Impresa;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DittaRepository extends JpaRepository<Ditta, Integer>, JpaSpecificationExecutor<Ditta> {
    @EntityGraph("ditta-impresaAnno-entity-graph")
    List<Ditta> findAll();

//    List<Ditta> findByImpresa_Id(Integer id);

    List<Ditta> findAll(Specification<Ditta> specification);


}