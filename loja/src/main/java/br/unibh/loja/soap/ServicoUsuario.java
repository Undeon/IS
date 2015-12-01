package br.unibh.loja.soap;

import javax.jws.WebParam;
import javax.jws.WebService;
import br.unibh.loja.model.Usuario;

@WebService(name = "usuario", targetNamespace = "http://www.unibh.br")
public interface ServicoUsuario {
	
	public Usuario[] listarTodos();

	public Usuario[] listar(@WebParam(name = "nome") String nome);

	public Usuario login(@WebParam(name="login") String login, @WebParam(name="senha") String senha);
	
}
