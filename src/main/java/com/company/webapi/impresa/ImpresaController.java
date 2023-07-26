package com.company.webapi.impresa;

import com.company.webapi.impresa.Repositories.ImpresaRepository;
import com.company.webapi.impresa.dtos.ImpresaDTO;
import com.company.webapi.impresa.dtos.ImpresaFilterDTO;
import com.company.webapi.impresa.entities.Impresa;
import com.company.webapi.impresa.exceptions.ImpresaNotFoundException;
import com.company.webapi.impresa.mappers.ImpresaMapper;
import com.company.webapi.impresa.services.ImpresaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
@RequiredArgsConstructor
@Tag(name = "Impresa")
@RequestMapping("/api/v1/impresa")
public class ImpresaController {

	private final ImpresaService impresaService;
	private final ImpresaMapper impresaDTOMapper;

 	@GetMapping()
	private ResponseEntity<List<ImpresaDTO>> get(
			@RequestParam(value = "anno", required = false) Integer anno
	) {
		 var impresaFilterDTO = new ImpresaFilterDTO(anno);

		 var list = impresaService
				 .GetAll(impresaFilterDTO)
				 .stream()
				 .map(impresaDTOMapper)
				 .collect(Collectors.toList());

		 return ResponseEntity.ok(list);
	}

//	@GetMapping("/{id}")
//	private ResponseEntity<ImpresaDTO> getById(@PathVariable int id) {
//		var impresa = impresaRepository
//				.findById(id)
//				.orElseThrow(() -> new ImpresaNotFoundException(id));
//
//		return ResponseEntity.ok(impresaDTOMapper.apply(impresa));
//	}
//
//	@PostMapping()
//	private ResponseEntity<String> post(@Valid @RequestBody Impresa impresa) {
//		return ResponseEntity.ok("Impresa is valid");
//	}

}