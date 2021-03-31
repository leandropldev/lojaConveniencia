package br.com.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AppLojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppLojaApplication.class, args);
		
		System.out.println("Senha encriptada: " + new BCryptPasswordEncoder(16).encode("admin123"));
	}
}
