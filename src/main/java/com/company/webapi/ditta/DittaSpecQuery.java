package com.company.webapi.ditta;
import com.company.webapi.ditta.dtos.DittaFilterDTO;
import com.company.webapi.ditta.entities.Ditta;
import com.company.webapi.ditta.entities.Ditta_;
import com.company.webapi.impresa.dtos.ImpresaFilterDTO;
import com.company.webapi.impresa.entities.Impresa;
import com.company.webapi.impresa.entities.Impresa_;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class DittaSpecQuery {

    static Specification<Ditta> createSpecification(DittaFilterDTO filter){
        return isActive(filter.getImpresaId());
    }

    private static Specification<Ditta> isActive(Integer impresaId) {
        return (root, query, builder) -> {
            if(Objects.isNull(impresaId)){
                return builder.conjunction();
            }

            return builder.equal(root.get(Ditta_.impresa).get(Impresa_.id), impresaId);
        };
    }

}