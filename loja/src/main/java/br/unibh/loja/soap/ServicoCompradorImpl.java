package br.unibh.loja.soap;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import br.unibh.loja.model.Comprador;

@WebService(endpointInterface = "br.unibh.loja.soap.ServicoComprador", serviceName = "comprador")
@Stateless
public class ServicoCompradorImpl implements ServicoComprador {
	@Inject
	private EntityManager em;
	@Inject
	private Logger log;

	@SuppressWarnings("unchecked")
	@Override
	public Comprador[] listarTodos() {
		log.info("Encontrando todos os compradores");
		List<Object> lista = em.createQuery("from Comprador").getResultList();
		return lista.toArray(new Comprador[lista.size()]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Comprador[] listar(String nome) {
		log.info("Encontrando comprador " + nome);
		List<Object> lista = em.createQuery("select c from Comprador c where c.nome like :nome")
				.setParameter("nome", nome + "%").getResultList();
		return lista.toArray(new Comprador[lista.size()]);
	}

	@Override
	public Comprador buscar(int id) {
		log.info("Encontrando comprador cujo id = " + id);
		return em.find(Comprador.class, new Long(id));
	}

	@Override
	public Comprador salvar(Comprador comprador) {
		log.info("Persistindo " + comprador);
		em.persist(comprador);
		return comprador;
	}

	@Override
	public Comprador atualizar(Comprador comprador) {
		log.info("Atualizando " + comprador);
		return em.merge(comprador);
	}

	@Override
	public void excluir(int id) {
		log.info("Removendo comprador cujo id = " + id);
		em.remove(em.find(Comprador.class, new Long(id)));
	}
}
