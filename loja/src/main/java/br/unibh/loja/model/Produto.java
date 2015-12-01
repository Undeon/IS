package br.unibh.loja.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_produto", uniqueConstraints = @UniqueConstraint(columnNames = "descricao") )
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=255,nullable=false)
	private String descricao;
	
	@Column(length=50,nullable=false)
	private String marca;
	
	@Column(nullable=false)
	private BigDecimal preco;
	
	@Column(name="cnpj_fornecedor",columnDefinition="char(14)",nullable=false)
	private String cnpjFornecedor;
	
	@Column(name="nome_fornecedor",length=100,nullable=false)
	private String nomeFornecedor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro",nullable=false)
	private Date dataCadastro;
	
	//GET AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}
	public void setCnpjFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public Date getDataDatastro() {
		return dataCadastro;
	}
	public void setDataDatastro(Date dataDatastro) {
		this.dataCadastro = dataDatastro;
	}
	
	//Construtor Padrão
	public Produto() {
		super();
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", marca=" + marca + ", preco=" + preco
				+ ", cnpjFornecedor=" + cnpjFornecedor + ", nomeFornecedor=" + nomeFornecedor + ", dataDatastro="
				+ dataCadastro + "]";
	}
	
}