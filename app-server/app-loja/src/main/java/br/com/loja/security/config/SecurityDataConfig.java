package br.com.loja.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties("security-data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityDataConfig {
	
	private String secret_key;
	private long expire_lenght;
}
