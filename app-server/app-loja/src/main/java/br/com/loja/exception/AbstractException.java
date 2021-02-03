package br.com.loja.exception;
 
public abstract class AbstractException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	protected String texto;
	
	protected AbstractException(String texto) {
		this.texto = texto;
	}
	
	public String getTexto() {
		return this.texto;
	}
}
