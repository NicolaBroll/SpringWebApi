package com.company.webapi.ditta;

import com.company.webapi.ditta.dtos.DittaDTO;
import com.company.webapi.ditta.exceptions.DittaNotFoundException;
import com.company.webapi.ditta.mappers.DittaMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
@RequiredArgsConstructor
@Tag(name = "Ditta")
@RequestMapping("/api/v1/ditta")
public class DittaController {

	private final DittaRepository dittaRepository;
	private final DittaMapper dittaMapper;

 	@GetMapping()
	private ResponseEntity<List<DittaDTO>> get() {

		 var list = dittaRepository
				 .findAll()
				 .stream()
				 .map(dittaMapper)
				 .collect(Collectors.toList());

		 return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	private ResponseEntity<DittaDTO> getById(@PathVariable int id) {
		var impresa = dittaRepository
				.findById(id)
				.orElseThrow(() -> new DittaNotFoundException(id));

		return ResponseEntity.ok(dittaMapper.apply(impresa));
	}

}