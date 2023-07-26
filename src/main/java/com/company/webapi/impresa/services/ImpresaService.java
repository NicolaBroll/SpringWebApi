package com.company.webapi.impresa.services;

import com.company.webapi.impresa.Repositories.ImpresaAnnoRepository;
import com.company.webapi.impresa.SpecQuery;
import com.company.webapi.impresa.dtos.ImpresaFilterDTO;
import com.company.webapi.impresa.models.ImpresaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ImpresaService {

    private final ImpresaAnnoRepository impresaAnnoRepository;

    public List<ImpresaModel> GetAll(ImpresaFilterDTO impresaFilterDTO){
        var result = new ArrayList<ImpresaModel>(){};

        var lstImpresaAnno = this.impresaAnnoRepository.findAll(SpecQuery.createSpecification(impresaFilterDTO));

        if(lstImpresaAnno.isEmpty()){
            return result;
        }

        for (var impresaAnno: lstImpresaAnno) {
            var impresa = impresaAnno.getImpresa();

            if(Objects.isNull(impresa)){
                continue;
            }

            var impresaModel = new ImpresaModel(
                    impresaAnno.getId(),
                    impresaAnno.getAnno(),
                    impresa.getChiave(),
                    impresaAnno.getRagioneSociale(),
                    impresaAnno.getPivaCF());

            result.add((impresaModel));
        }

        return result;
    }
}
