package br.com.loja.security.dto;

import java.io.Serializable;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCredentialsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String username;
	@NotNull
	private String password;

}
