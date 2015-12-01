package br.unibh.loja.soap;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import br.unibh.loja.model.Produto;

@WebService(endpointInterface = "br.unibh.loja.soap.ServicoProduto", serviceName = "produto")
@Stateless
public class ServicoProdutoImpl implements ServicoProduto {
	@Inject
	private EntityManager em;
	@Inject
	private Logger log;

	@SuppressWarnings("unchecked")
	@Override
	public Produto[] listarTodos() {
		log.info("Encontrando todos os produtos");
		List<Object> lista = em.createQuery("from Produto").getResultList();
		return lista.toArray(new Produto[lista.size()]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Produto[] listar(String descricao) {
		log.info("Encontrando produto " + descricao);
		List<Object> lista = em.createQuery("select c from Produto c where c.descricao like :descricao")
				.setParameter("descricao", descricao + "%").getResultList();
		return lista.toArray(new Produto[lista.size()]);
	}

	@Override
	public Produto buscar(int id) {
		log.info("Encontrando produto cujo id = " + id);
		return em.find(Produto.class, new Long(id));
	}

	@Override
	public Produto salvar(Produto produto) {
		log.info("Persistindo " + produto);
		em.persist(produto);
		return produto;
	}

	@Override
	public Produto atualizar(Produto produto) {
		log.info("Atualizando " + produto);
		return em.merge(produto);
	}

	@Override
	public void excluir(int id) {
		log.info("Removendo produto cujo id = " + id);
		em.remove(em.find(Produto.class, new Long(id)));
	}
}