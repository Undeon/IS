package br.unibh.pessoas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.entidades.PessoaJuridica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;
import br.unibh.pessoas.persistencia.PessoaJuridicaDAO;

public class Testes {

	
	//TESTE PESSOA FISICA
	
	@Test
	public void testePessoaFisicaFindAll() {

		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		List<PessoaFisica> l = dao.findAll();
		Assert.assertEquals(l.size(), 100);

	}

	@Test
	public void testePessoaFisicaFind() {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica p = dao.find(6L);
		Assert.assertEquals(p.getNome(), "Ainsley X. Payne");
	}

	@Test
	public void testePessoaFisicaInserir() {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pf = new PessoaFisica(null, "Fulano", "Rua das Oito", "31-6581-9852", "29874196302", "cicrano@ksfs.com", new Date(), "M");
		dao.insert(pf);
		PessoaFisica pf2 = dao.find("Fulano");
		Assert.assertNotNull(pf2);
		dao.delete(pf2);
		PessoaFisica pf3 = dao.find("Fulano");
		Assert.assertNull(pf3);
	}

	@Test
	public void testePessoaFisicaAtualizar() {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pf = new PessoaFisica(null, "Ciclano da Silva", "Rua das Oito", "31-6581-9852", "44464818285", "cicrano@ksfs.com", new Date(), "M");
		dao.insert(pf);
		PessoaFisica pf2 = dao.find("Ciclano da Silva");
		Assert.assertNotNull(pf2);
		
		pf2.setNome("Beltrano da Silva");
		dao.update(pf2);
		PessoaFisica pf3 = dao.find("Beltrano da Silva");
		Assert.assertNotNull(pf3);
		
		dao.delete(pf3);
		PessoaFisica pf4 = dao.find("Beltrano da Silva");
		Assert.assertNull(pf4);
	}
	
	//TESTE PESSOA JURIDICA
	
	@Test
	public void testePessoaJuridicaFindAll() {

		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		List<PessoaJuridica> l = dao.findAll();
		Assert.assertEquals(l.size(), 100);

	}

	@Test
	public void testePessoaJuridicaFind() {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica p = dao.find(6L);
		Assert.assertEquals(p.getNome(), "Travis H. Galloway");
	}

	@Test
	public void testePessoaJuridicaInserir() {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica pj = new PessoaJuridica(null, "Son Goku", "Av 1", "31734883197", "47219835671425", new Date(), "www.capsulecorp.com");
		dao.insert(pj);
		PessoaJuridica pj2 = dao.find("Son Goku");
		Assert.assertNotNull(pj2);
		dao.delete(pj2);
		PessoaJuridica pj3 = dao.find("Son Goku");
		Assert.assertNull(pj3);
	}

	@Test
	public void testePessoaJuridicaAtualizar() {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica pj = new PessoaJuridica(null, "Son Gohan", "Av 2", "51438823196", "37715895372415", new Date(), "www.capsulecorporation.com");
		dao.insert(pj);
		PessoaJuridica pj2 = dao.find("Son Gohan");
		Assert.assertNotNull(pj2);
		
		pj2.setNome("Son Goten");
		dao.update(pj2);
		PessoaJuridica pj3 = dao.find("Son Goten");
		Assert.assertNotNull(pj3);
		
		dao.delete(pj3);
		PessoaJuridica pj4 = dao.find("Son Goten");
		Assert.assertNull(pj4);
	}
}