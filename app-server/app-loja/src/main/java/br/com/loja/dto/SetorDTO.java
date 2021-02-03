package br.com.loja.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SetorDTO {

	private Integer id;
	private String nome;
}
