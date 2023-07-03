package com.company.webapi.ditta;

import com.company.webapi.ditta.entities.Ditta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DittaRepository extends JpaRepository<Ditta, Integer> {
}