package br.com.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.loja.dto.ApiResponseDTO;
import br.com.loja.repository.SetorRepository;

@Service
public class SetorService {
	
	@Autowired
	private SetorRepository repository;
	
	public ApiResponseDTO listAll(){
		return ApiResponseDTO.builder()
			.message("Recurso listar setores realizado com sucesso")
			.data(repository.findAll())
			.status(HttpStatus.OK).build();
	}
	
	public ApiResponseDTO listById(int id){
		
		if(!repository.findById(id).isPresent())
			System.out.println("Erro");
		
		return ApiResponseDTO.builder()
				.message("Recurso listar setores realizado com sucesso")
				.data(repository.findById(id))
				.status(HttpStatus.OK).build();
	}
}
