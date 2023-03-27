package com.company.webapi.impresa.dto;

import com.company.webapi.impresa.entities.Impresa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImpresaDTOMapper implements Function<Impresa, ImpresaDTO> {

    private final ImpresaAnnoDTOMapper impresaAnnoDTOMapper;

    @Override
    public ImpresaDTO apply(Impresa impresa){
        return new ImpresaDTO(
                impresa.getId(),
                impresa.getIsActive(),
                impresa.getLstImpresaAnno()
                        .stream()
                        .map(impresaAnnoDTOMapper)
                        .collect(Collectors.toList())
        );
    }
}
