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
@Table(name = "tb_usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"cpf", "login"}) )

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100,nullable=false)
	private String nome;
	
	@Column(columnDefinition="char(11)",nullable=false)
	private String cpf;
	
	@Column(length=100,nullable=false)
	private String email;
	
	@Column(length=15,nullable=false)
	private String login;
	
	@Column(length=100,nullable=false)
	private String senha;
	
	@Column(length=50,nullable=false)
	private String perfil;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ultimo_login",nullable=false)
	private Date data_ultimo_login;
	
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


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}


	public Date getdata_ultimo_login() {
		return data_ultimo_login;
	}


	public void setdata_ultimo_login(Date data_ultimo_login) {
		this.data_ultimo_login = data_ultimo_login;
	}


	public Usuario() {
	}

	public Usuario(Long id, String nome, String cpf, String email, String login, String senha, String perfil, Date data_ultimo_login) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.data_ultimo_login = data_ultimo_login;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", login=" + login + ", senha=" + senha + ", perfil=" + perfil
				+ ", data_ultimo_login=" + data_ultimo_login + "]";
	}
	
}
