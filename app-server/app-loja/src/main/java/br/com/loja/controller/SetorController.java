package br.com.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.dto.ApiResponseDTO;
import br.com.loja.service.SetorService;

@RestController
@RequestMapping("/setor")
public class SetorController {

	@Autowired
	private SetorService service;
	
	@GetMapping
	public ResponseEntity<ApiResponseDTO> listaSetores(){
		ApiResponseDTO data = service.listAll();
		return new ResponseEntity<ApiResponseDTO>(data, data.getStatus());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponseDTO> listaSetoresPorId(@PathVariable int id){
		ApiResponseDTO data = service.listById(id);
		return new ResponseEntity<ApiResponseDTO>(data, data.getStatus());
	}
}
