package service;

import java.util.List;
import java.util.Scanner;

import dao.ProfessorDAO;
import entities.Professor;

public class ProfessorService {
	private static Scanner entrada = new Scanner(System.in);
	
	
	public void imprimeProfessores() {
		listarProfessores();		
	}
	public void imprimeProfessorById() {
		listarProfessorPorId(recebeIdProfessor());
	}
	
	
	public void excluirProfessor() {
		excluirProfessor(recebeIdProfessor());
	}
	
	
	public void atualizarProfessor() {
		Professor professor = new Professor();
		
		professor.setNome(recebeNomeProfessor());
		professor.setMatricula(recebeMatricula());
		professor.setDataNascimento(recebeDataNascProfessor());
		professor.setEspecializacao(recebeEspecializacaoProfessor());
		
		updateProfessor(professor);
	}
	
	private static String recebeNomeProfessor() {
		System.out.println("Informe o nome do aluno:");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String recebeEspecializacaoProfessor() {
		System.out.println("Informe a especialização do professor:");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String recebeIdProfessor() {
		System.out.println("Informe o id do professor:");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String recebeMatricula() {
		System.out.println("Informe a matricula do professor:");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String recebeDataNascProfessor() {
		System.out.println("Informe a data de nascimento do professor (Ex.: 22/02/2000):");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private List<Professor> listarProfessores() {
		return ProfessorDAO.getProfessores();
	}

	private Professor listarProfessorPorId(String id) {
		return ProfessorDAO.getProfessorPorId(id);
	}

	private void excluirProfessor(String id) {
		ProfessorDAO.excluirProfessor(id);
	}

	private void updateProfessor(Professor professor) {
		ProfessorDAO.atualizarProfessor(professor);
	}
    
}
