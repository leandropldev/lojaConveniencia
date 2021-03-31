package br.com.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.dto.ApiResponseDTO;
import br.com.loja.security.dto.AccountCredentialsDTO;
import br.com.loja.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService service;
	
	@PostMapping
	public ResponseEntity<ApiResponseDTO> createSetor(@Validated @RequestBody AccountCredentialsDTO login){
		ApiResponseDTO data = service.doLogin(login);
		return new ResponseEntity<ApiResponseDTO>(data, data.getStatus());
	}
}
