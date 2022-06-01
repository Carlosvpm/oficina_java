package service;

import java.util.List;

import dao.ProfessorDAO;
import entities.Professor;

public class ProfessorService {
	
	public List<Professor> listarProfessores() {
		return ProfessorDAO.getProfessores();
	}

	public Professor listarProfessorPorId(String id) {
		return ProfessorDAO.getProfessorPorId(id);
	}

	public List<Professor> excluirProfessor(String id) {
		return ProfessorDAO.excluirProfessor(id);
	}

	public Professor atualizarProfessor(Professor professor) {
		return ProfessorDAO.atualizarProfessor(professor);
	}
    
}
