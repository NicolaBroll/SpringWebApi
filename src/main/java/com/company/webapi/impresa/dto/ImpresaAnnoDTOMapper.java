package com.company.webapi.impresa.dto;

import com.company.webapi.impresa.entities.ImpresaAnno;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ImpresaAnnoDTOMapper implements Function<ImpresaAnno, ImpresaAnnoDTO> {
    @Override
    public ImpresaAnnoDTO apply(ImpresaAnno impresaAnno){
        return new ImpresaAnnoDTO(
                impresaAnno.getAnno(),
                impresaAnno.getRagioneSociale()
        );
    }
}
