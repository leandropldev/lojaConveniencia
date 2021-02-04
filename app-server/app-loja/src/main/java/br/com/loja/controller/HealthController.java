package br.com.loja.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.dto.ApiResponseDTO;

@RestController
@RequestMapping("/health")
public class HealthController {

	@GetMapping
	public ResponseEntity<ApiResponseDTO> health() {
		return new ResponseEntity<>(ApiResponseDTO.builder()
					.data(null)
					.message("Aplicação rodando em docker!")
					.status(HttpStatus.OK).build(), HttpStatus.OK);
	}
}
