package br.com.loja.exception.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.loja.dto.ApiResponseDTO;
import br.com.loja.exception.ServiceException;
import br.com.loja.security.exceptions.InvalidJwtAuthenticationException;

@RestControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		if(ex != null) {
			for(FieldError error : ex.getBindingResult().getFieldErrors()) {
				errors.add(error.getField() + ": " + error.getDefaultMessage());
			}
			for(ObjectError error : ex.getBindingResult().getGlobalErrors()) {
				errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
			}
		}
		ApiResponseDTO data = ApiResponseDTO.builder()
			.data(errors)
			.message("Campo(s) inválidos na requisição!")
			.status(HttpStatus.BAD_REQUEST)
			.build();
		return new ResponseEntity<Object>(data, data.getStatus());
	}
	
	@ExceptionHandler(value = {ServiceException.class})
	protected ResponseEntity<ApiResponseDTO> handleServiceExpetion(ServiceException ex, WebRequest request){
		ApiResponseDTO data = ApiResponseDTO.builder()
			.data(null)
			.message(ex.getTexto())
			.status(HttpStatus.BAD_REQUEST)
			.build();
		return new ResponseEntity<ApiResponseDTO>(data, data.getStatus());
	}
	
	@ExceptionHandler(value = {InvalidJwtAuthenticationException.class})
	protected ResponseEntity<ApiResponseDTO> handleInvalidJwtAuthenticationException(Exception ex, WebRequest request){
		ApiResponseDTO data = ApiResponseDTO.builder()
			.data(null)
			.message(ex.getMessage())
			.status(HttpStatus.BAD_REQUEST)
			.build();
		return new ResponseEntity<ApiResponseDTO>(data, data.getStatus());
	}
	
	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<ApiResponseDTO> handleExpetion(Exception ex, WebRequest request){
		ApiResponseDTO data = ApiResponseDTO.builder()
			.data(null)
			.message("Erro Interno!")
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.build();
		return new ResponseEntity<ApiResponseDTO>(data, data.getStatus());
	}
}
