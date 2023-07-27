package com.company.webapi.impresa.services;

import com.company.webapi.impresa.ImpresaAnnoSpecQuery;
import com.company.webapi.impresa.dtos.ImpresaFilterDTO;
import com.company.webapi.impresa.exceptions.ImpresaNotFoundException;
import com.company.webapi.impresa.mappers.ImpresaModelMapper;
import com.company.webapi.impresa.models.ImpresaModel;
import com.company.webapi.impresa.repositories.ImpresaAnnoRepository;
import com.company.webapi.shared.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImpresaService {

    private final ImpresaAnnoRepository impresaAnnoRepository;
    private final ImpresaModelMapper impresaModelMapper;

    public PageResult<ImpresaModel> GetAll(ImpresaFilterDTO impresaFilterDTO){
        var spec = ImpresaAnnoSpecQuery.createSpecification(impresaFilterDTO);

        var queryPageResult = this.impresaAnnoRepository.findAll(spec, impresaFilterDTO.getPageRequest());
        var list = queryPageResult.getContent();
        var totalCount = queryPageResult.getTotalElements();

        var result = list
                .stream()
                .map(impresaModelMapper)
                .toList();

        return PageResult.create(result, totalCount);
    }

    public ImpresaModel getById(Integer id){
        var impresaAnno = this.impresaAnnoRepository.findById(id).orElseThrow(() -> new ImpresaNotFoundException(id));
        return impresaModelMapper.apply(impresaAnno);
    }
}
