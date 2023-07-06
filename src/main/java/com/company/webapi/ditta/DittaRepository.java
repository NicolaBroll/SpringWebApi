package com.company.webapi.ditta;

import com.company.webapi.ditta.entities.Ditta;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DittaRepository extends JpaRepository<Ditta, Integer> {
    @EntityGraph("ditta-impresa-entity-graph")
    List<Ditta> findAll();

}