package com.company.webapi.impresa;

import com.company.webapi.impresa.dtos.ImpresaDTO;
import com.company.webapi.impresa.dtos.ImpresaFilterDTO;
import com.company.webapi.impresa.mappers.ImpresaMapper;
import com.company.webapi.impresa.services.ImpresaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
@Tag(name = "Impresa")
@RequestMapping("/api/v1/impresa")
public class ImpresaController {

	private final ImpresaService impresaService;
	private final ImpresaMapper impresaDTOMapper;

	public ImpresaController(ImpresaService impresaService, ImpresaMapper impresaDTOMapper) {
		this.impresaService = impresaService;
		this.impresaDTOMapper = impresaDTOMapper;
	}

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

	@GetMapping("/{id}")
	private ResponseEntity<ImpresaDTO> getById(@PathVariable int id) {
		var impresaModel = impresaService.getById(id);

		return ResponseEntity.ok(impresaDTOMapper.apply(impresaModel));
	}

}