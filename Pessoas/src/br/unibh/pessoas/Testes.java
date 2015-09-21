package br.unibh.pessoas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;

public class Testes {
	
	@Test
	public void testePessoaFisicaFindAll(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		List<PessoaFisica> l = dao.findAll();
		Assert.assertEquals(l.size(), 100);
		
	}
	
	@Test
	public void testePessoaFisicaFind(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica p = dao.find(6L);
		Assert.assertEquals("Ainsley X. Payne", p.getNome());
	}

	@Test
	public void testePessoaFisicaInserir(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pf = new PessoaFisica(null, "Son Goku", "Rua A", "3133334444", "07899458708", "goku@capsule.corp", new Date(), "M");
		dao.insert(pf);
		
		PessoaFisica pf2 = dao.find("Son Goku");
		Assert.assertNotNull(pf2);
		dao.delete(pf2);
	}
	
	@Test
	public void testePessoaFisicaAtualizar(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pf = new PessoaFisica(	null, "Son Gohan", "Rua A", "3133334444", "14755268704", "gohan@capsule.corp", new Date(), "M");
		dao.insert(pf);
		
		PessoaFisica pf2 = dao.find("Son Gohan");
		pf2.setNome("Son Goten");
		pf2.setEmail("goten@capsule.corp");
		dao.update(pf2);
		
		PessoaFisica pf3 = dao.find("Son Goten");
		Assert.assertEquals(pf3.getEmail(), "goten@capsule.corp");
		Assert.assertNotNull(pf3);
		dao.delete(pf3);
		
	}
}
