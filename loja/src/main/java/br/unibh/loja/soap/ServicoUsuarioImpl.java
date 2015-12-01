package br.unibh.loja.soap;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import br.unibh.loja.model.Usuario;

@WebService(endpointInterface = "br.unibh.loja.soap.ServicoUsuario", serviceName = "usuario")
@Stateless
public class ServicoUsuarioImpl implements ServicoUsuario {

	@Inject
	private EntityManager em;
	@Inject
	private Logger log;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario[] listarTodos() {
		log.info("Encontrando todos os usuario");
		List<Object> lista = em.createQuery("from Usuario").getResultList();
		return lista.toArray(new Usuario[lista.size()]);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario[] listar(String nome) {
		log.info("Encontrando usuario " + nome);
		List<Object> lista = em
				.createQuery(
						"select c from Usuario c	where c.nome like :nome")
				.setParameter("nome", nome + "%").getResultList();
		return lista.toArray(new Usuario[lista.size()]);
	}
	
	@Override
	public Usuario login(String login, String senha) {
		log.info("Encontrando Usuario " + login + senha);
		Usuario usuario = (Usuario) em
				.createQuery(
						"select c from Usuario c	where c.login = :login and c.senha = :senha")
				.setParameter("login",login).setParameter("senha", senha).getSingleResult();
		return usuario;
		
		
	}
	
}
