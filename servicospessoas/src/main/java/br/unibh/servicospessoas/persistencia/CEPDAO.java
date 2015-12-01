package br.unibh.servicospessoas.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unibh.servicospessoas.entidades.CEP;

public class CEPDAO implements DAO<CEP, Long> {

	
	public List<CEP>findCep(String endereco){
		List<CEP> listCep = new ArrayList<CEP>();
		try {
			String sql = "select * from tb_cep where endereco like ?";
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(sql); 
			p.setString(1, "%"+endereco+"%");
			
			ResultSet res = p.executeQuery();
			while (res.next()){
				CEP cep = new CEP(
							res.getLong("cep"), res.getString("endereco"), res.getString("cidade"));
				listCep.add(cep);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		
		return listCep;
		
	}

	@Override
	public void insert(CEP t) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(
					"insert into tb_cep " + "(cep, endereco, cidade,) values " + "(?, ?, ?)");
			p.setLong(1, t.getCep());
			p.setString(2, t.getEndereco());
			p.setString(3, t.getCidade());
			p.executeUpdate();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	@Override
	public void update(CEP t) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(
					"update tb_cep set cep = ?, endereco = ?, cidade = ? where cep = ?");
			p.setLong(1, t.getCep());
			p.setString(2, t.getEndereco());
			p.setString(3, t.getCidade());
			p.executeUpdate();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public void delete(CEP t) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement("delete from tb_cep where cep  = ?");
			p.setLong(1, t.getCep());
			p.executeUpdate();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	@Override
	public List<CEP> findAll() {
		List<CEP> listaCep = new ArrayList<CEP>();
		try {
			
			String sql = "select * from tb_cep";
			ResultSet res = JDBCUtil.getConnection().
					prepareStatement(sql).executeQuery();
			
			while (res.next()) {
				listaCep.add(
						new CEP(
							res.getLong("cep"), res.getString("endereco"), res.getString("cidade") 
						)
					);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return listaCep;
	}

	@Override
	public CEP find(Long cep) {
		CEP cepObject = null;
		try{
			String sql = "select * from tb_cep where cep = ?";
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(sql); 
			p.setLong(1, cep);
			
			ResultSet res = p.executeQuery();
			if (res.next()){
				cepObject = new CEP(
						res.getLong("cep"), res.getString("endereco"), res.getString("cidade") 
					);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return cepObject;
	}
}
