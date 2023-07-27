package com.company.webapi.impresa.mappers;

import com.company.webapi.impresa.dtos.ImpresaDTO;
import com.company.webapi.impresa.models.ImpresaModel;
import com.company.webapi.shared.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ImpresaDtoPageMapper implements Function<PageResult<ImpresaModel>, PageResult<ImpresaDTO>> {

    private final ImpresaDtoMapper impresaDtoMapper;

    @Override
    public PageResult<ImpresaDTO> apply(PageResult<ImpresaModel> impresa){

        var list = impresa
                .getData()
                .stream()
                .map(impresaDtoMapper)
                .toList();

        return PageResult.create(list, impresa.getTotalCount());
    }

}
