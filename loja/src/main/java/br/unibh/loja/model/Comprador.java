package br.unibh.loja.model;

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
@Table(name = "tb_comprador", uniqueConstraints = @UniqueConstraint(columnNames = "cpf") )
public class Comprador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100,nullable=false)
	private String nome;
	
	@Column(length=255,nullable=false)
	private String endereco;
	
	@Column(columnDefinition="char(12)",nullable=false)
	private String telefone1;
	
	@Column(columnDefinition="char(12)",nullable=true)
	private String telefone2;
	
	@Column(columnDefinition="char(11)",nullable=false)
	private String cpf;
	
	@Column(length=100,nullable=false)
	private String email;
	
	@Column(name="data_nascimento",nullable=true)
	private Date dataNascimento;
	
	@Column(columnDefinition="char(1)",nullable=false)
	private String sexo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro",nullable=false)
	private Date dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataDatastro() {
		return dataCadastro;
	}

	public void setDataDatastro(Date dataDatastro) {
		this.dataCadastro = dataDatastro;
	}

	public Comprador() {
	}

	@Override
	public String toString() {
		return "Comprador [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone1=" + telefone1
				+ ", telefone2=" + telefone2 + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
				+ dataNascimento + ", sexo=" + sexo + ", dataDatastro=" + dataCadastro + "]";
	}

}
