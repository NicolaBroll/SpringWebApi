package com.company.webapi.impresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImpresaRepository extends JpaRepository<Impresa, Integer> {
    @Query("SELECT i FROM Impresa i INNER JOIN FETCH  i.lstImpresaAnno ia")
    List<Impresa> findAllNew();
}