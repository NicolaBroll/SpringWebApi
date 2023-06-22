package com.company.webapi.impresa;

import com.company.webapi.impresa.dtos.ImpresaDTO;
import com.company.webapi.impresa.entities.Impresa;
import com.company.webapi.impresa.mappers.ImpresaDTOMapper;
import com.company.webapi.impresa.exceptions.ImpresaNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.webapi.impresa.SpecQuery.isActive;

@RestController
@ControllerAdvice
@RequiredArgsConstructor
@Tag(name = "Impresa")
@RequestMapping("/api/v1/impresa")
public class ImpresaController {

	private final ImpresaRepository impresaRepository;
	private final ImpresaDTOMapper impresaDTOMapper;

 	@GetMapping()
	private ResponseEntity<List<ImpresaDTO>> get() {
		 var list =impresaRepository
				 .findAllNew()
				 .stream()
				 .map(impresaDTOMapper)
				 .collect(Collectors.toList());

		 return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	private ResponseEntity<ImpresaDTO> getById(@PathVariable int id) {
		var impresa = impresaRepository
				.findById(id)
				.orElseThrow(() -> new ImpresaNotFoundException(id));

		return ResponseEntity.ok(impresaDTOMapper.apply(impresa));
	}

	@PostMapping()
	private ResponseEntity<String> post(@Valid @RequestBody Impresa impresa) {
		return ResponseEntity.ok("Impresa is valid");
	}

}