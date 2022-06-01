
import service.AlunoService;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;

public class Main {


	private static Scanner entrada = new Scanner(System.in);


	@SuppressWarnings("unused")
	private static AlunoService alunoService = new AlunoService();

	public static void main(String[] args) throws SQLException {
		
	
		boolean continuar = true;

		while (continuar) {
			exibeMenu();

			switch (entrada.nextLine()) {
			case "1":
				limpaTela();
				AlunoService.adicionarAluno();
				pressioneQualquerTecla();
				break;
			case "2":
				limpaTela();
				AlunoService.listarAlunos();
				pressioneQualquerTecla();
				break;
			case "3":
				limpaTela();
				AlunoService.buscarAlunoPorId();
				pressioneQualquerTecla();
				break;
			case "4":
				limpaTela();
				AlunoService.atualizarAluno();
				pressioneQualquerTecla();
				break;
			case "5":
				limpaTela();
				AlunoService.excluirAluno();
				pressioneQualquerTecla();
				break;
			case "17":
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
		System.out.println("4 - Atualizar aluno");
		System.out.println("5 - Excluir aluno");
		System.out.println("6 - Cadastrar professor");
		System.out.println("7 - Buscar professor por id");
		System.out.println("8 - Listar professor");
		System.out.println("9 - Atualizar professor");
		System.out.println("10 - Excluir professor");
		System.out.println("11 - Sair");
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
