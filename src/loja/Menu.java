package loja;

import java.util.InputMismatchException;
import java.util.Scanner;

import loja.controller.FilmeController;
import loja.model.EdicaoEspecial;
import loja.model.EdicaoSimples;
import loja.model.Filme;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final FilmeController filmeController = new FilmeController();

	public static void main(String[] args) {

		int opcao;

		while (true) {

			System.out.println("\n\n******************************************");
			System.out.println("*             ACERVO LILICINE            *");
			System.out.println("*       Onde o cinema vira relíquia      *");
			System.out.println("******************************************");
			System.out.println("*                                        *");
			System.out.println("*     1 - Cadastrar Filme                *");
			System.out.println("*     2 - Listar todos os  filmes        *");
			System.out.println("*     3 - Atualizar dados do Filme       *");
			System.out.println("*     4 - Apagar filme                   *");
			System.out.println("*     0 - Sair                           *");
			System.out.println("*                                        *");
			System.out.println("******************************************");
			System.out.println("Entre com a opção desejada:               ");
			System.out.println("                                          ");
			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro!");
				leia.nextLine();
			}
			

			if (opcao == 0) {
				System.out.println("==========================================================");
				System.out.println("            Luz, câmera e... até logo!                    ");
				System.out.println("       Obrigada por visitar o Acervo LiliCine.            ");
				System.out.println("  Guarde bem suas relíquias e até a próxima sessão!       ");
				System.out.println("==========================================================");
				leia.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Filme\n\n");
				cadastrarFilme();
				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Filmes\n\n");
				listarFilmes();
				keyPress();
				break;
			case 3:
				System.out.println("Atualizar dados do filme\n\n");
				atualizarFilme();
				keyPress();
				break;
			case 4:
				System.out.println("Apagar Filme\n\n");
				deletarFilme();
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}
	
	public static void keyPress() {
		System.out.println("\n\nPressione Enter para Continuar...");
		leia.nextLine();
	}
	
	private static void listarFilmes() {
		filmeController.listarTodos();
	}
	
	private static void cadastrarFilme() {
		System.out.print("Digite o Título do filme: ");
		String titulo = leia.nextLine();

		System.out.print("Digite o nome do Diretor: ");
		String diretor = leia.nextLine();
		
		System.out.print("Digite o Gênero do Filme: ");
		String genero = leia.nextLine();
		
		System.out.print("Digite o Ano de Lançamento do Filme: ");
		int anoLancamento = leia.nextInt();
		
		System.out.print("Digite o Preço do Filme: ");
		float preco = leia.nextFloat();

		System.out.print("Digite o tipo do DVD (1 - Edição Simples | 2 - Edição Especial): ");
		int tipo = leia.nextInt();

		switch (tipo) {
		case 1 -> {
			System.out.println("O DVD possui algum extra? (1 - Sim | 2 - Não) ");
			int possuiExtra = leia.nextInt();
			filmeController.cadastrar(
					new EdicaoSimples(filmeController.gerarId(), titulo, diretor, genero, anoLancamento, preco, tipo, possuiExtra));
		}
		case 2 -> {
			System.out.println("O DVD possui algum Brinde Físico? (1 - Sim | 2 - Não) ");
			int possuiBrinde = leia.nextInt();
			filmeController.cadastrar(
					new EdicaoEspecial(filmeController.gerarId(), titulo, diretor, genero, anoLancamento, preco, tipo, possuiBrinde));
		}
		default -> System.out.println("Tipo de Filme inválido!");
		}
	}
	
	private static void atualizarFilme() {
		
		System.out.print("Digite o número identificador do filme: ");
		int idFilme = leia.nextInt();
		leia.nextLine();

		Filme filme = filmeController.buscarNaCollection(idFilme);

		if (filme != null) {

			String titulo = filme.getTitulo();
			String diretor = filme.getDiretor();
			String genero = filme.getGenero();
			int anoLancamento = filme.getAnoLancamento();
			float preco = filme.getPreco();
			int tipo = filme.getTipo();
			String entrada;

			System.out.println("Título atual: " + titulo + "\nNovo Título (pressione ENTER para manter): ");
			entrada = leia.nextLine();
			titulo = entrada.isEmpty() ? titulo : entrada;

			System.out.println("Diretor atual: " + diretor + "\nNovo Diretor (pressione ENTER para manter): ");
			entrada = leia.nextLine();
			diretor = entrada.isEmpty() ? diretor : entrada;
			
			System.out.println("Genero atual: " + genero + "\nNovo Genero (pressione ENTER para manter): ");
			entrada = leia.nextLine();
			genero = entrada.isEmpty() ? genero : entrada;
			
			System.out.println("Ano de Lançamento atual: " +  anoLancamento + "\nNovo Ano de Lançamento (pressione ENTER para manter): " );
			entrada = leia.nextLine();
			anoLancamento = entrada.isEmpty() ? anoLancamento : Integer.parseInt(entrada);

			System.out.printf("Preço Atual: R$ %.2f%n", preco);
			System.out.print("Novo Preço (pressione ENTER para manter): ");
			entrada = leia.nextLine();
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(',', '.'));

			switch (tipo) {
			case 1 -> {
				int possuiExtra = ((EdicaoSimples) filme).getPossuiExtraNoDisco();

				System.out.println("Ano de Lançamento atual: " +  possuiExtra + "\nNovo Ano de Lançamento (pressione ENTER para manter): " );
				entrada = leia.nextLine();
				possuiExtra = entrada.isEmpty() ? possuiExtra : Integer.parseInt(entrada);

				filmeController.atualizar(new EdicaoSimples(idFilme, titulo, diretor, genero, anoLancamento, preco, tipo, possuiExtra));
			}
			case 2 -> {
				int possuiBrinde = ((EdicaoEspecial) filme).getBrindesFisicos();
				System.out.println("Ano de Lançamento atual: " +  possuiBrinde + "\nNovo Ano de Lançamento (pressione ENTER para manter): " );
				entrada = leia.nextLine();
				possuiBrinde = entrada.isEmpty() ? possuiBrinde : Integer.parseInt(entrada);

				filmeController.atualizar(new EdicaoEspecial(idFilme, titulo, diretor, genero, anoLancamento, preco, tipo, possuiBrinde));
			}
			default -> System.out.println("Tipo de filme inválido!");
			}

		} else {
			System.out.printf("\nO filme não foi encontrada!\n");
		}
	}
	
	private static void deletarFilme() {
		
		System.out.print("Digite o número de identificação do filme: ");
		int idFilme = leia.nextInt();
		leia.nextLine();
		
		System.out.print("\nTem certeza que deseja excluir esta conta? (S/N): ");
		String confirmacao = leia.nextLine();
		
		if(confirmacao.equalsIgnoreCase("S")) {
			filmeController.deletar(idFilme);
		}else {
			System.out.println("\nOperação Cancelada.");
		}
	}
}
