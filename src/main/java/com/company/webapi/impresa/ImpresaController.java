package com.company.webapi.impresa;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/impresa")
public class ImpresaController {

	private final ImpresaRepository impresaRepository;

 	@GetMapping()
	private List<Impresa> get() {
		return impresaRepository.findAllNew();
	}

}