package br.com.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.loja.converter.DozerConverter;
import br.com.loja.dto.ApiResponseDTO;
import br.com.loja.dto.SetorDTO;
import br.com.loja.entity.Setor;
import br.com.loja.exception.ServiceException;
import br.com.loja.repository.SetorRepository;

@Service
public class SetorService {
	
	@Autowired
	private SetorRepository repository;
	
	public ApiResponseDTO listAll(){
		return ApiResponseDTO.builder()
				.message("Recurso /get setor realizado com sucesso")
				.data(repository.findAll())
				.status(HttpStatus.OK).build();
	}
	
	public ApiResponseDTO listById(int id){
		if(!repository.findById(id).isPresent())
			throw new ServiceException("Id do setor não encontrado!");
		
		return ApiResponseDTO.builder()
				.message("Recurso /get/{id} setor realizado com sucesso")
				.data(repository.findById(id))
				.status(HttpStatus.OK).build();
	}
	
	public ApiResponseDTO create(SetorDTO data) {
		Setor save = repository.save(DozerConverter.parseObject(data, Setor.class));
		return ApiResponseDTO.builder()
				.message("Recurso /post setor realizado com sucesso")
				.data(save)
				.status(HttpStatus.CREATED).build();
	}
	
	public ApiResponseDTO update(int id, SetorDTO dto) {
		if(!repository.findById(id).isPresent())
			throw new ServiceException("Setor não encontrado!");
		
		Setor save = repository.save(DozerConverter.parseObject(dto, Setor.class));
		return ApiResponseDTO.builder()
				.message("Recurso /update setor realizado com sucesso")
				.data(save)
				.status(HttpStatus.OK).build();
	}
	
	public ApiResponseDTO delete(int id) {
			if(!repository.findById(id).isPresent())
				throw new ServiceException("Setor não encontrado!");
			
			repository.deleteById(id);
			return ApiResponseDTO.builder()
					.message("Recurso /delete setor realizado com sucesso")
					.data(id)
					.status(HttpStatus.OK).build();
	}
}
