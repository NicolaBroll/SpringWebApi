package com.company.webapi.impresa.repositories;

import com.company.webapi.impresa.entities.ImpresaAnno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImpresaAnnoRepository extends
        PagingAndSortingRepository<ImpresaAnno, Integer>,
        JpaSpecificationExecutor<ImpresaAnno> {

    @EntityGraph("EG_impresaAnnoWithImpresa")
    Page<ImpresaAnno> findAll(Specification<ImpresaAnno> specification, Pageable pageable);

    @EntityGraph("EG_impresaAnnoWithImpresa")
    Optional<ImpresaAnno> findById(Integer id);

}