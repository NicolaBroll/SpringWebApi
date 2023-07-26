package com.company.webapi.impresa.dtos;

public record ImpresaDTO(
    Integer id,
    Integer anno,
    String  chiave,
    String ragioneSociale,
    String pivaCF
){}