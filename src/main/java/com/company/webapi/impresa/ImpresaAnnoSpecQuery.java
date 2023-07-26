package com.company.webapi.impresa;

import com.company.webapi.impresa.dtos.ImpresaFilterDTO;
import com.company.webapi.impresa.entities.ImpresaAnno;
import com.company.webapi.impresa.entities.ImpresaAnno_;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class ImpresaAnnoSpecQuery {

    public static Specification<ImpresaAnno> createSpecification(ImpresaFilterDTO filter){
        return filterAnno(filter.getAnno())
                .and(impresaNotNull());
    }

    private static Specification<ImpresaAnno> filterAnno(Integer anno) {
        return (root, query, builder) -> {
            if(Objects.isNull(anno)){
                return builder.conjunction();
            }

            return builder.equal(root.get(ImpresaAnno_.ANNO), anno);
        };
    }

    private static Specification<ImpresaAnno> impresaNotNull() {
        return (root, query, builder) -> builder.isNotNull(root.get(ImpresaAnno_.IMPRESA));
    }

}