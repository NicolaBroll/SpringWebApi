package com.company.webapi.impresa.mappers;

import com.company.webapi.impresa.dtos.ImpresaAnnoDTO;
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
