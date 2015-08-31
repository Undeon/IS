package br.unibh.pessoas.entidades;

import java.util.Date;

public class PessoaJuridica extends Pessoa {
	
	private String cnpj;
	private Date dataConstituicao;
	private String site;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getDataConstituicao() {
		return dataConstituicao;
	}
	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}

	public PessoaJuridica(Long id, String nome, String endereco, String telefone, String cnpj, Date dataConstituicao, String site) {
		super(id, nome, endereco, telefone);
		this.cnpj = cnpj;
		this.dataConstituicao = dataConstituicao;
		this.site = site;
	}
	
	public PessoaJuridica(String cnpj, Date dataConstituicao, String site) {
		super();
		this.cnpj = cnpj;
		this.dataConstituicao = dataConstituicao;
		this.site = site;
	}
	
	@Override
	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj + ", dataConstituicao=" + dataConstituicao + ", site=" + site 	+ ", toString()=" + super.toString() + "]";
	}
	
	
}
