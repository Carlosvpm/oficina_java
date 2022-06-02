package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import config.DataBase;
import entities.Professor;
import shared.BaseDao;

public class ProfessorDAO extends BaseDao {

    public ProfessorDAO() {
		BaseDao.connection = new DataBase().conect();
	}
    

    public void adicionarBanco(Professor professor) {
		String sql = "INSERT INTO professor(nome, dt_nasc, dt_cadastro,especializacao, matricula) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getDataNascimento());
			stmt.setString(3, professor.getDataCadastro());
			stmt.setString(4, professor.getEspecializacao());
            stmt.setString(5, professor.getMatricula());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

    public static List<Professor> getProfessores() {
		String sql = "SELECT * FROM professor";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaProfessores(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Professor getProfessorPorId(String idProfessor) {
		String sql = "SELECT * FROM professor WHERE id = " + idProfessor;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaProfessor(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void excluirProfessor(String idProfessor) {
		String sql = "DELETE FROM professor WHERE id = " + idProfessor;
		try {
			Statement stmt = connection.createStatement();
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void atualizarProfessor(Professor professor) {
		String sql = "UPDATE professor SET nome = ?, dt_cadastro = ?, dt_nasc = ?, matricula = ? WHERE id = ?";
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
			preparedStatement.setString(1, professor.getNome());
			preparedStatement.setString(2, professor.getDataCadastro());
			preparedStatement.setString(3, professor.getDataNascimento());
			preparedStatement.setString(4, professor.getMatricula());
			preparedStatement.setString(5, professor.getId());
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	private static Professor recuperaProfessor(Statement stmt, ResultSet rs) throws SQLException {
		Professor professor = new Professor();
		if (rs.next()) {
			professor.setId(rs.getString("id"));
			professor.setNome(rs.getString("nome"));
			professor.setDataNascimento(rs.getString("dt_nasc"));
			professor.setDataCadastro(rs.getString("dt_cadastro"));
			professor.setDataCadastro(rs.getString("especializacao"));
            professor.setMatricula(rs.getString("matricula"));
		}
		stmt.close();
		return professor;
	}
    private static List<Professor> recuperaProfessores(Statement stmt, ResultSet rs) throws SQLException {
		List<Professor> lista = new ArrayList<Professor>();

		while (rs.next()) {
			Professor professor = new Professor();

			professor.setId(rs.getString("id"));
			professor.setNome(rs.getString("nome"));
			professor.setDataNascimento(rs.getString("dt_nasc"));
			professor.setDataCadastro(rs.getString("dt_cadastro"));
			professor.setDataCadastro(rs.getString("especializacao"));
            professor.setMatricula(rs.getString("matricula"));
			lista.add(professor);
		}

		stmt.close();

		return lista;
	}
}
