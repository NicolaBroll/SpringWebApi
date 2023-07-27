package com.company.webapi.impresa.dtos;

import lombok.*;
import org.springframework.data.domain.PageRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ImpresaFilterDTO {

    private PageRequest pageRequest;
    private Integer anno;

    public ImpresaFilterDTO(Integer anno, PageRequest pageRequest) {
        this.anno = anno;
        this.pageRequest = pageRequest;
    }
}
