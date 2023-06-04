import java.security.Principal;
import java.util.Scanner;

import static java.security.Principal.*;

public class Menu {
    public static int opcao;
    public  static Scanner entrada = new Scanner(System.in);

    public  void menu(Arvore arvore) {
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
                System.out.println("Insira o RGM para remoção: ");
                int rgm = entrada.nextInt();
                Aluno aluno = new Aluno(rgm);
                arvore.remover(arvore.raiz,aluno);
                menu(arvore);
                break;
            case 3:
                break;
            case 4:
                System.out.println("Cuidado! Essa operação vai apagar toda àrvore de Alunos!\n Deseja Continuar? [1] Sim \n [2] Não");
                opcao = entrada.nextInt();
                switch (opcao){
                    case 1:
                        arvore.raiz = null;
                        break;
                    case 2:
                        menu(arvore);
                        break;
                }


                menu(arvore);
                break;
            case 5:
                System.out.println("Como você deseja exibir a Árvore? \n [1] InOrdem \n [2] PreOrdem \n [3] PosOrdem \n [4] Voltar");
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
    public void func_ExibirArvore(Arvore arvore){
        switch (opcao){
            case 1:
                System.out.println("/////////////");
                arvore.percorrerInOrdem(arvore.raiz);
                System.out.println("/////////////");
                break;
            case 2:
                System.out.println("/////////////");
                arvore.percorrerPreOrdem(arvore.raiz);
                System.out.println("/////////////");
                break;
            case 3:
                System.out.println("/////////////");
                arvore.percorrerPosOrdem(arvore.raiz);
                System.out.println("/////////////");
                break;
            case 4:
                System.out.println("/////////////");
                System.out.println("Retornando ao Menu Inicial...");
                System.out.println("/////////////");
                menu(arvore);
                break;
        }

    }



}
