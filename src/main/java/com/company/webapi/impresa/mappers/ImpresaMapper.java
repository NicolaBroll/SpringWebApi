package com.company.webapi.impresa.mappers;

import com.company.webapi.impresa.dtos.ImpresaDTO;
import com.company.webapi.impresa.models.ImpresaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ImpresaMapper implements Function<ImpresaModel, ImpresaDTO> {

    @Override
    public ImpresaDTO apply(ImpresaModel impresa){
        return new ImpresaDTO(
            impresa.getId(),
            impresa.getAnno(),
            impresa.getChiave(),
            impresa.getRagioneSociale(),
            impresa.getPivaCF()
        );
    }

}
