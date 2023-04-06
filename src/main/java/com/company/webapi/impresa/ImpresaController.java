package com.company.webapi.impresa;

import com.company.webapi.impresa.dtos.ImpresaDTO;
import com.company.webapi.impresa.mappers.ImpresaDTOMapper;
import com.company.webapi.impresa.exceptions.ImpresaNotFoundException;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.webapi.impresa.SpecQuery.isActive;

@RestController
@ControllerAdvice
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

	@GetMapping("/{id}")
	private ImpresaDTO getById(@PathVariable int id) {
		var impresa = impresaRepository
				.findById(id)
				.orElseThrow(() -> new ImpresaNotFoundException(id));

		return impresaDTOMapper.apply(impresa);
	}

}