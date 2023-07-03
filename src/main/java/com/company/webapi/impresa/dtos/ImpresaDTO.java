package com.company.webapi.impresa.dtos;

public record ImpresaDTO(
    Integer id,
    Integer anno,
    String  ragioneSociale,
    Boolean IsDisattivata,
    String pivaCF
){}