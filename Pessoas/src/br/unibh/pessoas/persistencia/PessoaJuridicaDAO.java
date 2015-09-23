package br.unibh.pessoas.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.unibh.pessoas.entidades.PessoaJuridica;

public class PessoaJuridicaDAO implements DAO<PessoaJuridica, Long> {

	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public PessoaJuridica find(Long id) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement("select * from tb_pessoa_Juridica " + "where id = ?");

			p.setLong(1, id);

			ResultSet res = p.executeQuery();

			if (res.next()) {
				return new PessoaJuridica(res.getLong("id"), res.getString("nome"), res.getString("endereco"), res.getString("telefone"), res.getString("cnpj"), res.getDate("data_Constituicao"), res.getString("site"));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}

	public PessoaJuridica find(String nome) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement("select * from tb_pessoa_Juridica " + "where nome like ?");

			p.setString(1, nome + "%");

			ResultSet res = p.executeQuery();

			if (res.next()) {
				return new PessoaJuridica(res.getLong("id"), res.getString("nome"), res.getString("endereco"), res.getString("telefone"), res.getString("cnpj"), res.getDate("data_Constituicao"), res.getString("site"));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}

	@Override
	public void insert(PessoaJuridica t) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(
					"insert into tb_pessoa_Juridica (nome, endereco, telefone, cnpj, data_Constituicao, site) values " + "(?, ?, ?, ?, ?, ?)");
			p.setString(1, t.getNome());
			p.setString(2, t.getEndereco());
			p.setString(3, t.getTelefone());
			p.setString(4, t.getCnpj());
			p.setString(5, df.format(t.getDataConstituicao()));
			p.setString(6, t.getSite());
			p.executeUpdate();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	@Override
	public void update(PessoaJuridica t) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(
					"update tb_pessoa_Juridica set nome = ?, endereco = ?, telefone = ?, cnpj = ?, data_Constituicao = ?, site = ? where id = ?");
			p.setString(1, t.getNome());
			p.setString(2, t.getEndereco());
			p.setString(3, t.getTelefone());
			p.setString(4, t.getCnpj());
			p.setString(5, df.format(t.getDataConstituicao()));
			p.setString(6, t.getSite());
			p.setLong(7, t.getId());
			p.executeUpdate();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public void delete(PessoaJuridica t) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement("delete from tb_pessoa_Juridica where id  = ?");
			p.setLong(1, t.getId());
			p.executeUpdate();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	@Override
	public List<PessoaJuridica> findAll() {

		List<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();

		try {

			String sql = "select * from tb_pessoa_Juridica";
			ResultSet res = JDBCUtil.getConnection().prepareStatement(sql).executeQuery();

			while (res.next()) {

				lista.add(new PessoaJuridica(res.getLong("id"), res.getString("nome"), res.getString("endereco"), res.getString("telefone"), res.getString("cnpj"), res.getDate("data_Constituicao"), res.getString("site")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return lista;
	}

}