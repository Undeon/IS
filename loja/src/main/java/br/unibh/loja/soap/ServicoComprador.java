package br.unibh.loja.soap;

import javax.jws.WebParam;
import javax.jws.WebService;
import br.unibh.loja.model.Comprador;

@WebService(name = "comprador", targetNamespace = "http://www.unibh.br")
public interface ServicoComprador {
	public Comprador[] listarTodos();

	public Comprador[] listar(@WebParam(name = "nome") String nome);

	public Comprador buscar(@WebParam(name = "id") int id);

	public Comprador salvar(@WebParam(name = "comprador") Comprador comprador);

	public Comprador atualizar(@WebParam(name = "comprador") Comprador comprador);

	public void excluir(@WebParam(name = "id") int id);
}
