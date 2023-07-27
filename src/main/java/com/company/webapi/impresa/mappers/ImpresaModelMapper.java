package com.company.webapi.impresa.mappers;

import com.company.webapi.impresa.entities.ImpresaAnno;
import com.company.webapi.impresa.models.ImpresaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ImpresaModelMapper implements Function<ImpresaAnno, ImpresaModel> {
    @Override
    public ImpresaModel apply(ImpresaAnno impresaAnno){
        var impresa = impresaAnno.getImpresa();

        return new ImpresaModel(
                impresaAnno.getId(),
                impresaAnno.getAnno(),
                impresa.getChiave(),
                impresaAnno.getRagioneSociale(),
                impresaAnno.getPivaCF());
    }
}
