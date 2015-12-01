package br.unibh.loja.soap;

import javax.xml.ws.WebFault;

@WebFault(name = "exception")
public class SoapException extends Exception {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private SoapException() {
	}

	public SoapException(String message, Throwable cause) {
		super(message, cause);
	}

	public SoapException(String message) {
		super(message);
	}
}
