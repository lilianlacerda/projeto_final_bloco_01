package loja;

import java.util.Scanner;

import loja.model.EdicaoEspecial;
import loja.model.EdicaoSimples;
import loja.model.Filme;

public class Menu {

	private static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		//Testando classe filme
		EdicaoEspecial f2 = new EdicaoEspecial(1, "O Auto da Compadecida", "Guel Arraes", "Comédia", 1999, 30.00f, 1, 2);
		EdicaoSimples f3 = new EdicaoSimples(1, "O Auto da Compadecida", "Guel Arraes", "Comédia", 1999, 30.00f, 1, 1);
		
		f3.visualizar();

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
			opcao = leia.nextInt();

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
				break;
			case 2:
				System.out.println("Listar todos os Filmes\n\n");
				break;
			case 3:
				System.out.println("Atualizar dados do filme\n\n");
				break;
			case 4:
				System.out.println("Apagar Filme\n\n");
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}

	}

}
