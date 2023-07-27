package com.company.webapi.impresa.services;

import com.company.webapi.impresa.ImpresaAnnoSpecQuery;
import com.company.webapi.impresa.dtos.ImpresaFilterDTO;
import com.company.webapi.impresa.entities.ImpresaAnno;
import com.company.webapi.impresa.exceptions.ImpresaNotFoundException;
import com.company.webapi.impresa.models.ImpresaModel;
import com.company.webapi.impresa.repositories.*;
import com.company.webapi.shared.PageResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ImpresaService {

    private final ImpresaAnnoRepository impresaAnnoRepository;

    public ImpresaService(ImpresaAnnoRepository impresaAnnoRepository) {
        this.impresaAnnoRepository = impresaAnnoRepository;
    }

    public PageResult<ImpresaModel> GetAll(ImpresaFilterDTO impresaFilterDTO){
        var result = new ArrayList<ImpresaModel>(){};
        var spec = ImpresaAnnoSpecQuery.createSpecification(impresaFilterDTO);

        var lstImpresaAnno = this.impresaAnnoRepository.findAll(spec, impresaFilterDTO.getPageRequest());

        for (var impresaAnno: lstImpresaAnno.getContent()) {
            var impresaModel = fromEntityToModel(impresaAnno);
            result.add((impresaModel));
        }

        return PageResult.create(result, lstImpresaAnno.getTotalElements());
    }

    public ImpresaModel getById(Integer id){
        var impresaAnno = this.impresaAnnoRepository.findById(id).orElseThrow(() -> new ImpresaNotFoundException(id));
        return fromEntityToModel(impresaAnno);
    }

    private static ImpresaModel fromEntityToModel(ImpresaAnno impresaAnno) {
        var impresa = impresaAnno.getImpresa();

        return new ImpresaModel(
                impresaAnno.getId(),
                impresaAnno.getAnno(),
                impresa.getChiave(),
                impresaAnno.getRagioneSociale(),
                impresaAnno.getPivaCF());
    }
}
