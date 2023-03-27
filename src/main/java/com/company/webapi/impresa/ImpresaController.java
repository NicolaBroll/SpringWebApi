package com.company.webapi.impresa;

import com.company.webapi.impresa.dto.ImpresaDTO;
import com.company.webapi.impresa.dto.ImpresaDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.webapi.impresa.SpecQuery.isActive;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/impresa")
public class ImpresaController {

	private final ImpresaRepository impresaRepository;
	private final ImpresaDTOMapper impresaDTOMapper;

 	@GetMapping()
	private List<ImpresaDTO> get() {
		 return impresaRepository
				 .findAll(isActive(true))
				 .stream()
				 .map(impresaDTOMapper)
				 .collect(Collectors.toList());
	}

}