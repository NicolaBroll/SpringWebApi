package com.company.webapi.impresa.dto;

import java.util.List;

public record ImpresaDTO(Integer id, Boolean isActive, List<ImpresaAnnoDTO> lstImpresaAnnoDto){}