package service;

import dao.AlunoDAO;
import entities.Aluno;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AlunoService {
	private static Scanner entrada = new Scanner(System.in);

	private static AlunoDAO alunoDAO = new AlunoDAO();
	
	
	
	public static void adicionarAluno() {
		Aluno aluno = new Aluno();

		String nome = recebeNomeAluno();	
		aluno.setNome(nome);
		
		String nomeMae = recebeNomeMaeAluno();
		aluno.setNomeMae(nomeMae);
		
		String nomePai = recebeNomePaiAluno();		
		aluno.setNomePai(nomePai);
 
		String dataNasc = recebeDataNascAluno();
		aluno.setDataNascimento(dataNasc);
		
		validaAluno(aluno);
	}
	
	public static void atualizarAluno(){
		Aluno aluno = new Aluno();
		

		String nome = recebeNomeAluno();	
		aluno.setNome(nome);
		
		String nomeMae = recebeNomeMaeAluno();
		aluno.setNomeMae(nomeMae);
		
		String nomePai = recebeNomePaiAluno();		
		aluno.setNomePai(nomePai);
 
		String dataNasc = recebeDataNascAluno();
		aluno.setDataNascimento(dataNasc);
		
		String idAluno = recebeIdAluno();
		aluno.setId(idAluno);
		
		validaAluno(aluno);
		
		update(aluno);	
	}
	
	public static void listarAlunos() {
		List<Aluno> alunos = getAll();
		imprimeAlunos(alunos);		
	}
	
	public static void listarAlunos(int a) {
		List<Aluno> alunos = getAll();
		imprimeAlunos(alunos);		
	}

	


	public static void buscarAlunoPorId() {
		String idAluno = recebeIdAluno();
		Aluno aluno = getById(idAluno);
		imprimeAluno(aluno);
	}
	
	
	
	public static void excluirAluno() {
		String idAlunoExcluido = recebeIdAluno();		 
		delete(idAlunoExcluido);
	}
	

	private static void imprimeAlunos(List<Aluno> listaAlunos) {
		Iterator<Aluno> it = listaAlunos.iterator();

		while(it.hasNext()) {
			Aluno aluno = it.next();

			System.out.printf("%-4s\t", aluno.getId());
			System.out.printf("%-20s\t", aluno.getNome());
			System.out.printf("%-10s\t", aluno.getDataNascimento());
			System.out.println();
		}
	}
	private static void imprimeAluno(Aluno aluno) {
			System.out.printf("%-4s\t", aluno.getId());
			System.out.printf("%-20s\t", aluno.getNome());
			System.out.printf("%-10s\t", aluno.getDataNascimento());
			System.out.printf("%-10s\t", aluno.getDataCadastro());
			System.out.printf("%-10s\t", aluno.getNomeMae());
			System.out.printf("%-10s\t", aluno.getNomePai());
			System.out.println();
	}

	private static Aluno validaAluno(Aluno aluno) {
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
	
	private static String recebeNomeAluno() {
		System.out.println("Informe o nome do aluno:");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String recebeIdTurmaAluno() {
		System.out.println("Informe o id da turma do aluno:");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String recebeNomeMaeAluno() {
		System.out.println("Informe o nome da Mae do Aluno:");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String recebeNomePaiAluno() {
		System.out.println("Informe o nome do Pai do Aluno:");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String recebeDataNascAluno() {
		System.out.println("Informe a data de nascimento do aluno (Ex.: 22/02/2000):");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String recebeIdAluno() {
		System.out.print("Informe o id do aluno: ");
		String resposta = entrada.nextLine();
		return resposta;
	}
	

	
	private static List<Aluno> getAll() {
		return alunoDAO.getAlunos();
	}
	private static void delete(String idAluno) {
		alunoDAO.excluirAluno(idAluno);
	}
	
	private static void update(Aluno aluno) {
		alunoDAO.atualizarAluno(aluno);
	}
	

	private static Aluno getById(String id) {
		return alunoDAO.getAlunoPorId(id);
	}

}
