package com.company.webapi.ditta.mappers;

import com.company.webapi.ditta.dtos.DittaDTO;
import com.company.webapi.ditta.entities.Ditta;
import com.company.webapi.impresa.mappers.ImpresaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class DittaMapper implements Function<Ditta, DittaDTO> {

    @Override
    public DittaDTO apply(Ditta ditta){
        return new DittaDTO(
                ditta.getId(),
                ditta.getAnno(),
                ditta.getDenominazione()
        );
    }

}
