package com.company.webapi.impresa;

import com.company.webapi.impresa.dtos.ImpresaDTO;
import com.company.webapi.impresa.dtos.ImpresaFilterDTO;
import com.company.webapi.impresa.mappers.ImpresaDtoMapper;
import com.company.webapi.impresa.mappers.ImpresaDtoPageMapper;
import com.company.webapi.impresa.services.ImpresaService;
import com.company.webapi.shared.PageResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
@RequiredArgsConstructor
@Tag(name = "Impresa")
@RequestMapping("/api/v1/impresa")
public class ImpresaController {

	private final ImpresaService impresaService;
	private final ImpresaDtoPageMapper impresaDtoPageMapper;
	private final ImpresaDtoMapper impresaDtoMapper;

 	@GetMapping()
	public ResponseEntity<PageResult<ImpresaDTO>> get(
			@RequestParam(value = "anno", required = false) final Integer anno,
			@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "5") final Integer pageSize
	) {
		 var impresaFilterDTO = new ImpresaFilterDTO(anno, PageRequest.of(page, pageSize));
		 var list = this.impresaDtoPageMapper.apply(impresaService.GetAll(impresaFilterDTO));
		 return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ImpresaDTO> getById(@PathVariable int id) {
		var impresaModel = impresaService.getById(id);

		return ResponseEntity.ok(impresaDtoMapper.apply(impresaModel));
	}

}