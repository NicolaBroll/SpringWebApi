package com.company.webapi.impresa;

import com.company.webapi.impresa.entities.Impresa;
import org.springframework.data.jpa.domain.Specification;

public class SpecQuery{
    static Specification<Impresa> isActive(boolean isActive) {
        return (book, cq, cb) -> cb.equal(book.get("isActive"), isActive);
    }
}