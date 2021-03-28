package br.com.loja.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import br.com.loja.converter.DozerConverter;
import br.com.loja.dto.ApiResponseDTO;
import br.com.loja.entity.Setor;
import br.com.loja.exception.ServiceException;
import br.com.loja.security.dto.AccountCredentialsDTO;
import br.com.loja.security.entity.User;
import br.com.loja.security.jwt.JwtTokenProvider;
import br.com.loja.security.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	UserRepository repository;
 	
	public ApiResponseDTO doLogin(AccountCredentialsDTO loginDTO) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
			User user = repository.findByUserName(loginDTO.getUsername());
			String token = "";
			
			if(user != null) {
				token = tokenProvider.createToken(loginDTO.getUsername(), user.getRoles());
			} else {
				throw new ServiceException("Usuario " + loginDTO.getUsername() +  " não encontrado na base!");
			}
			
			//parse entity to dto 
			//DozerConverter.parseObject(user, Setor.class);
			
			Map<Object, Object> data = new HashMap<>();
			data.put("login", loginDTO.getUsername());
			data.put("token", token);
			
			return ApiResponseDTO.builder()
					.message("Recurso /get/{id} setor realizado com sucesso")
					.data(data)
					.status(HttpStatus.OK).build();
			
		} catch (Exception e) {
			throw new ServiceException("Erro ao logar na aplicação!");
		}
	}
}
