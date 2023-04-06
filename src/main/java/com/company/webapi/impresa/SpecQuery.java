package com.company.webapi.impresa;

import com.company.webapi.impresa.entities.Impresa;
import org.springframework.data.jpa.domain.Specification;

public class SpecQuery{
    static Specification<Impresa> isActive(boolean isActive) {
        return (impresa, cq, cb) -> cb.equal(impresa.get("isActive"), isActive);
    }
}