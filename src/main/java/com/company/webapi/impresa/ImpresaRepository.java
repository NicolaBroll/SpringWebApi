package com.company.webapi.impresa;

import com.company.webapi.impresa.entities.Impresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImpresaRepository extends JpaRepository<Impresa, Integer>, JpaSpecificationExecutor<Impresa> {
    @Query("SELECT i FROM Impresa i JOIN FETCH  i.lstImpresaAnno ia")
    List<Impresa> findAllNew();

}