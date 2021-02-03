package br.com.loja.exception;

public class ServiceException extends AbstractException{

	private static final long serialVersionUID = 1L;

	public ServiceException(String texto) {
		super(texto);
	}
}
