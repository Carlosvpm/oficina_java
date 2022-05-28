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
		this.connection = new DataBase().conect();
	}
    

    public void adicionarBanco(Professor professor) {
		String sql = "INSERT INTO professor(nome, dt_nasc, dt_cadastro, matricula) VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getDataNascimento());
			stmt.setString(3, professor.getDataCadastro());
            stmt.setString(4, professor.getMatricula());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

    public List<Professor> getProfessores() {
		String sql = "SELECT * FROM professor";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaprofessores(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Professor getProfessorPorId(String idProfessor) {
		String sql = "SELECT * FROM professor WHERE id = " + idProfessor;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaProfessor(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Professor> excluirProfessor(String idProfessor) {
		String sql = "DELETE FROM professor WHERE id = " + idProfessor;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaprofessores(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Professor atualizarProfessor(Professor professor) {
		String sql = "UPDATE professor SET nome = " + professor.getNome() + ",dt_nasc = " + professor.getDataNascimento()
				+ " WHERE id = " + professor.getId();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaProfessor(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Professor recuperaProfessor(Statement stmt, ResultSet rs) throws SQLException {
		Professor professor = new Professor();
		if (rs.next()) {
			professor.setId(rs.getInt("id"));
			professor.setNome(rs.getString("nome"));
			professor.setDataNascimento(rs.getString("dt_nasc"));
			professor.setDataCadastro(rs.getString("dt_cadastro"));
            professor.setMatricula(rs.getString("matricula"));
		}
		stmt.close();
		return professor;
	}
    private List<Professor> recuperaprofessores(Statement stmt, ResultSet rs) throws SQLException {
		List<Professor> lista = new ArrayList<Professor>();

		while (rs.next()) {
			Professor professor = new Professor();

			professor.setId(rs.getInt("id"));
			professor.setNome(rs.getString("nome"));
			professor.setDataNascimento(rs.getString("dt_nasc"));
			professor.setDataCadastro(rs.getString("dt_cadastro"));
            professor.setMatricula(rs.getString("matricula"));
			lista.add(professor);
		}

		stmt.close();

		return lista;
	}
}
