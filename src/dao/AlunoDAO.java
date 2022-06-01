package dao;

import config.DataBase;
import entities.Aluno;
import shared.BaseDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends BaseDao {


	public AlunoDAO() {
		BaseDao.connection = new DataBase().conect();
	}

	public void adicionarBanco(Aluno aluno) {
		String sql = "INSERT INTO aluno(nome, nome_mae, nome_pai, dt_nasc, dt_cadastro) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getNomeMae());
			stmt.setString(3, aluno.getNomePai());
			stmt.setString(4, aluno.getDataNascimento());
			stmt.setString(5, aluno.getDataCadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Aluno> getAlunos() {
		String sql = "SELECT * FROM aluno";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaAlunos(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Aluno getAlunoPorId(String idAluno) {
		String sql = "SELECT * FROM aluno WHERE id = "+ idAluno ;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaAluno(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluirAluno(String idAluno) {
		String sql = "DELETE FROM aluno WHERE id = ?";
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
			preparedStatement.setString(1, idAluno);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizarAluno(Aluno aluno){
		String sql = "UPDATE aluno SET nome = ?, nome_mae = ?, nome_pai = ?, dt_nasc = ? WHERE id = ?";
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
			preparedStatement.setString(1, aluno.getNome());
			preparedStatement.setString(2, aluno.getNomeMae());
			preparedStatement.setString(3, aluno.getNomePai());
			preparedStatement.setString(4, aluno.getDataNascimento());
			preparedStatement.setString(5, aluno.getId());
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	
	private Aluno recuperaAluno(Statement stmt, ResultSet rs) throws SQLException {
		Aluno aluno = new Aluno();
		if (rs.next()) {
			aluno.setId(rs.getString("id"));
			aluno.setNome(rs.getString("nome"));
			aluno.setNomeMae(rs.getString("nome_mae"));
			aluno.setNomePai(rs.getString("nome_pai"));
			aluno.setDataNascimento(rs.getString("dt_nasc"));
			aluno.setDataCadastro(rs.getString("dt_cadastro"));
		}
		stmt.close();
		return aluno;
	}

	private List<Aluno> recuperaAlunos(Statement stmt, ResultSet rs) throws SQLException {
		List<Aluno> lista = new ArrayList<Aluno>();

		while (rs.next()) {
			Aluno aluno = new Aluno();

			aluno.setId(rs.getString("id"));
			aluno.setNome(rs.getString("nome"));
			aluno.setNomeMae(rs.getString("nome_mae"));
			aluno.setNomePai(rs.getString("nome_pai"));
			aluno.setDataNascimento(rs.getString("dt_nasc"));
			aluno.setDataCadastro(rs.getString("dt_cadastro"));

			lista.add(aluno);
		}

		stmt.close();

		return lista;
	}
}
