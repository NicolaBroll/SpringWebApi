package com.company.webapi.impresa;

import com.company.webapi.impresa.entities.Impresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImpresaRepository extends JpaRepository<Impresa, Integer> {

//   @EntityGraph("impresa-entity-graph")
//   List<Impresa> findAll(Specification<Impresa> specification);

}