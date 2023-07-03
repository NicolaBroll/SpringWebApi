package com.company.webapi.impresa.mappers;

import com.company.webapi.impresa.dtos.ImpresaDTO;
import com.company.webapi.impresa.entities.Impresa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ImpresaMapper implements Function<Impresa, ImpresaDTO> {

    @Override
    public ImpresaDTO apply(Impresa impresa){
        return new ImpresaDTO(
            impresa.getId(),
            impresa.getAnno(),
            impresa.getRagioneSociale(),
            impresa.getIsDisattivata(),
            impresa.getPivaCF()
        );
    }

}
