package com.company.webapi.impresa.Repositories;

import com.company.webapi.impresa.entities.Impresa;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ImpresaRepository extends JpaRepository<Impresa, Integer>, JpaSpecificationExecutor<Impresa> {
   List<Impresa> findAll(Specification<Impresa> specification);

}