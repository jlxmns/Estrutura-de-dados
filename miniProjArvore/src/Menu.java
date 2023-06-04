import java.security.Principal;
import java.util.Scanner;

import static java.security.Principal.*;

public class Menu {
    public static int opcao;
    public  static Scanner entrada = new Scanner(System.in);

    public static void menu(Arvore arvore){
        System.out.println("Alunos: Marcos Lacet e Júlio Ximenes");
        System.out.println("Disciplina: Estrutura de Dados I");
        System.out.println("Professor: Walace Bonfim");
        System.out.println("");
        System.out.println("Editor de Árvore Binária");
        System.out.println("Opções: \n [1] Inserir \n [2] Remover \n [3] Pesquisar \n [4] Esvaziar \n [5] Exibir Árvore \n [0] Sair");
        opcao = entrada.nextInt();
        switch (opcao){
            case 1:

                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                System.out.println("Cuidado! Essa operação vai apagar toda àrvore de Alunos!\n Deseja Continuar? [1] Sim \n [2] Não");
                opcao = entrada.nextInt();
                break;
            case 5:
                System.out.println("Como você deseja exibir a Árvore? \n [1] InOrdem \n [2]PreOrdem \n [3]PosOrdem");
                opcao = entrada.nextInt();
                func_ExibirArvore(arvore);
                menu(arvore);
                break;
            case 0:
                System.out.println("Encerrando Aplicação...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                menu(arvore);

        }
    }
    public static void func_ExibirArvore(Arvore arvore){
        switch (opcao){
            case 1:
                arvore.percorrerInOrdem(arvore.raiz);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println("Retornando ao Menu Inicial...");
                menu(arvore);
        }

    }

    public static void apagarÁrvore(Arvore arvore){
        switch (opcao){
            case 1:
                break;
            case 2:
                menu(arvore);
        }
    }
}
