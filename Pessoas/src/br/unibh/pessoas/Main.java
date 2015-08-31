package br.unibh.pessoas;

import java.util.Date;

import br.unibh.pessoas.entidades.Pessoa;
import br.unibh.pessoas.entidades.PessoaFisica;

public class Main {
	
	
	public static void main(String[] args) {

		PessoaFisica pf1 = new PessoaFisica(1L, "João", "Rua Um, 45, Estrela Dalva", "(31) 3464-8874", "047.667.849-01", "joao@unibh.br", new Date(), "M");
		
		System.out.println(pf1);
		//System.out.println(p2);
		//System.out.println(p3);
	}
}
