package com.company.webapi.impresa.Repositories;

import com.company.webapi.impresa.entities.ImpresaAnno;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ImpresaAnnoRepository extends JpaRepository<ImpresaAnno, Integer>, JpaSpecificationExecutor<ImpresaAnno> {
    @EntityGraph("EG_impresaAnnoWithImpresa")
    List<ImpresaAnno> findAll(Specification<ImpresaAnno> specification);

}