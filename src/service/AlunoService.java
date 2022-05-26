package service;

import dao.AlunoDAO;
import entities.Aluno;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AlunoService {

	private AlunoDAO alunoDAO = new AlunoDAO();

	public Aluno validaAluno(Aluno aluno) {
		if (aluno.getNome() != null
				&& !aluno.getNome().isEmpty()
				&& aluno.getNomeMae() != null
				&& !aluno.getNomeMae().isEmpty()
				&& aluno.getDataNascimento() != null
				&& !aluno.getDataNascimento().isEmpty()) {
			aluno.setDataCadastro(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
			alunoDAO.adicionarBanco(aluno);
		} else {
			System.out.println(
					"Verifique os dados cadastrados. O nome do aluno, nome da mãe e data de nascimento são obrigatórios!");
		}

		return null;
	}

	public List<Aluno> listarAlunos() {
		return alunoDAO.getAlunos();
	}

	public List<Aluno> listarAlunoPorId(String id) {
		return alunoDAO.getAlunoPorId(id);
	}

	public List<Aluno> excluirAluno(String id) {
		return alunoDAO.excluirAluno(id);
	}

	public Aluno atualizarAluno(Aluno aluno) {
		return atualizarAluno(aluno);
	}

}
