package com.company.webapi.impresa.repositories;

import com.company.webapi.impresa.entities.ImpresaAnno;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ImpresaAnnoRepository extends
        JpaRepository<ImpresaAnno, Integer>,
        JpaSpecificationExecutor<ImpresaAnno> {
    @EntityGraph("EG_impresaAnnoWithImpresa")
    List<ImpresaAnno> findAll(Specification<ImpresaAnno> specification);

    @EntityGraph("EG_impresaAnnoWithImpresa")
    Optional<ImpresaAnno> findById(Integer id);

}