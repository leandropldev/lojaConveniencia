package br.com.loja.dto;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponseDTO {

	private Object data;
	private Object message;
	private HttpStatus status;
}
