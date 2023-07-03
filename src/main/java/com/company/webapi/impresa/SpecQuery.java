package com.company.webapi.impresa;
import com.company.webapi.impresa.dtos.ImpresaFilterDTO;
import com.company.webapi.impresa.entities.Impresa;
import com.company.webapi.impresa.entities.Impresa_;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class SpecQuery{

    static Specification<Impresa> createSpecification(ImpresaFilterDTO filter){
        return isActive(filter.getOnlyActive());
    }

    private static Specification<Impresa> isActive(Boolean onlyActive) {
        return (root, query, builder) -> {
            if(Objects.isNull(onlyActive)){
                return builder.conjunction();
            }

            if(!onlyActive){
                return builder.conjunction();
            }

            return builder.equal(root.get(Impresa_.IsDisattivata), true);
        };
    }

}