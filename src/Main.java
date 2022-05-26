
import service.AlunoService;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;

public class Main {

	// scanner para entrada de dados
	private static Scanner entrada = new Scanner(System.in);

	// classe responsavel por manipular alunos
	private static AlunoService alunoService = new AlunoService();

	public static void main(String[] args) throws SQLException {

		// flag que controla execucao do programa
		boolean continuar = true;

		while (continuar) {
			exibeMenu();

			switch (entrada.nextLine()) {
			case "1":
				limpaTela();
				adicionarAluno();
				pressioneQualquerTecla();
				break;
			case "2":
				limpaTela();
				listarAlunos();
				pressioneQualquerTecla();
				break;
			case "3":
				limpaTela();
				buscarPorId();
				pressioneQualquerTecla();
				break;
			case "4":
				limpaTela();
				System.out.println("Tchau... :)");
				pressioneQualquerTecla();
				continuar = false;
				break;
			default:
				limpaTela();
				System.out.println("Por favor, selecione uma opção válida.");
				pressioneQualquerTecla();
				break;
			}
			
			limpaTela();
		}

		entrada.close();
	}

	private static void exibeMenu() {
		System.out.println("Bem vindo, por favor digite uma opção válida: ");
		System.out.println("1 - Cadastrar aluno");
		System.out.println("2 - Listar alunos");
		System.out.println("3 - Buscar aluno por id");
		System.out.println("4 - Sair");
	}

	private static void adicionarAluno() {
		Aluno aluno = new Aluno();

		System.out.println("Informe o nome do aluno:");
		String resposta = entrada.nextLine();
		aluno.setNome(resposta);

		System.out.println("Informe o nome da Mae do Aluno:");
		resposta = entrada.nextLine();
		aluno.setNomeMae(resposta);

		System.out.println("Informe o nome do Pai do Aluno:");
		resposta = entrada.nextLine();
		aluno.setNomePai(resposta);

		System.out.println("Informe a data de nascimento do aluno (Ex.: 22/02/2000):");
		resposta = entrada.nextLine();
		aluno.setDataNascimento(resposta);

		alunoService.validaAluno(aluno);
	}

	private static void listarAlunos() {
		List<Aluno> listaAlunos = alunoService.listarAlunos();
		printaAlunos(listaAlunos);
	}

	private static void buscarPorId() {
		System.out.print("Informe o id do aluno: ");
		String idBusca = entrada.nextLine();
		List<Aluno> listaAlunos = alunoService.listarAlunoPorId(idBusca);
		printaAlunos(listaAlunos);
	}
	
	private static void printaAlunos(List<Aluno> listaAlunos) {
		Iterator<Aluno> it = listaAlunos.iterator();

		while(it.hasNext()) {
			Aluno aluno = it.next();

			System.out.printf("%-4s\t", aluno.getId());
			System.out.printf("%-20s\t", aluno.getNome());
			System.out.printf("%-10s\t", aluno.getDataNascimento());
			System.out.println();
		}
	}
	
	private static void limpaTela() {
		for (int i = 0; i < 100; i++) {
			System.out.println("\r\n");
		}
	}
	
	private static void pressioneQualquerTecla() {
		System.out.println("\n\nPressione qualquer tecla para continuar...");
		entrada.nextLine();
	}
}
