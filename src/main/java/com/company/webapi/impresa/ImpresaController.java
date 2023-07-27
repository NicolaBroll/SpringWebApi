package com.company.webapi.impresa;

import com.company.webapi.impresa.dtos.ImpresaDTO;
import com.company.webapi.impresa.dtos.ImpresaFilterDTO;
import com.company.webapi.impresa.mappers.ImpresaMapper;
import com.company.webapi.impresa.mappers.ImpresaPageMapper;
import com.company.webapi.impresa.services.ImpresaService;
import com.company.webapi.shared.PageResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
@Tag(name = "Impresa")
@RequestMapping("/api/v1/impresa")
public class ImpresaController {

	private final ImpresaService impresaService;
	private final ImpresaPageMapper impresaPageMapper;
	private final ImpresaMapper impresaMapper;

	public ImpresaController(ImpresaService impresaService, ImpresaPageMapper impresaPageMapper, ImpresaMapper impresaMapper) {
		this.impresaService = impresaService;
		this.impresaPageMapper = impresaPageMapper;
		this.impresaMapper = impresaMapper;
	}

 	@GetMapping()
	private ResponseEntity<PageResult<ImpresaDTO>> get(
			@RequestParam(value = "anno", required = false) final Integer anno,
			@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "5") final Integer pageSize
	) {
		 var impresaFilterDTO = new ImpresaFilterDTO(anno, PageRequest.of(page, pageSize));
		 var list = this.impresaPageMapper.apply(impresaService.GetAll(impresaFilterDTO));
		 return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	private ResponseEntity<ImpresaDTO> getById(@PathVariable int id) {
		var impresaModel = impresaService.getById(id);

		return ResponseEntity.ok(impresaMapper.apply(impresaModel));
	}

}