import java.util.Scanner;

public class Menu {
    private int opcao;
    private final Scanner entrada = new Scanner(System.in);

    public void menu(Arvore arvore) {
        //Cabeçalho
        System.out.println("Alunos: Marcos Lacet e Júlio Ximenes");
        System.out.println("Disciplina: Estrutura de Dados I");
        System.out.println("Professor: Walace Bonfim");
        System.out.println();
        System.out.println("Editor de Árvore Binária");
        System.out.println("Opções: \n [1] Inserir \n [2] Remover \n [3] Pesquisar \n [4] Esvaziar \n [5] Exibir Árvore \n [0] Sair");
        opcao = entrada.nextInt();

        //Variáveis usadas no Switch Case
        int rgm;
        String nome;

        //Opções do Menu
        switch (opcao) {

            case 1 -> {
                //Coleta de dados do usuário
                System.out.println("Insira o RGM do aluno: ");
                rgm = entrada.nextInt();
                System.out.println("Insira o nome do aluno: ");
                nome = entrada.next();

                //Adicionando aluno na árvore
                Aluno alunoAdd = new Aluno(rgm, nome);
                arvore.adicionarNo(alunoAdd);
                System.out.println("Aluno inserido com sucesso!");

                //Menu
                sairOuRetornar(arvore);

            }
            case 2 -> {
                //Coletando dados
                System.out.println("Insira o RGM para remoção: ");
                rgm = entrada.nextInt();

                //Criando um aluno e atribuindo um nome conforme o RGM informado
                Aluno alunoRem = new Aluno(rgm, arvore.buscarAluno(arvore.raiz, rgm));

                //Caso o aluno tenha nome (foi encontrado a partir do RGM) deleta o aluno
                //Caso contrário, avisa que o aluno não foi encontrado
                if(alunoRem.getNome() != null) {
                    System.out.println("Registro a ser removido: \n-RGM: " + alunoRem.getRgm() + " Aluno: " + alunoRem.getNome());
                    arvore.remover(arvore.raiz, alunoRem);
                    System.out.println("Aluno removido com sucesso!");
                } else {
                    System.out.println("Aluno com RGM " + rgm + " não existe.");
                }

                //Menu
                sairOuRetornar(arvore);
            }
            case 3 -> {
                //Coletando dados
                System.out.println("Insira o RGM para pesquisar: ");
                rgm = entrada.nextInt();

                //Checando se o usuário existe
                nome = arvore.buscarAluno(arvore.raiz, rgm);

                if (nome == null) {
                    System.out.println("Não foi possível encontrar nenhum aluno registrado com esse RGM.");
                } else {
                    System.out.println("Aluno encontrado! RGM: " + rgm + " Nome: " + nome);
                }

                //Menu
                sairOuRetornar(arvore);
            }
            case 4 -> {
                //Certificando a intenção e removendo a árvore
                System.out.println("Cuidado! Essa operação vai apagar toda àrvore de Alunos!\n Deseja Continuar? [1] Sim \n [2] Não");
                opcao = entrada.nextInt();
                switch (opcao) {
                    case 1 -> arvore.apagarArvore();
                    case 2 -> menu(arvore);
                }
                System.out.println("Árvore removida com sucesso!");

                //Menu
                sairOuRetornar(arvore);
            }
            case 5 -> {
                //Coletando dados
                System.out.println("Como você deseja exibir a Árvore? \n [1] InOrdem \n [2] PreOrdem \n [3] PosOrdem \n [4] Voltar");
                opcao = entrada.nextInt();

                //Exibindo a árvore se ela não for vazia
                if(arvore.raiz == null) {
                    System.out.println("A árvore está vazia.");
                } else {
                    func_ExibirArvore(arvore, opcao);
                }

                //Menu
                sairOuRetornar(arvore);
            }
            case 0 -> {
                System.out.println("Encerrando Aplicação...");
                System.exit(0);
            }
            default -> {
                System.out.println("Opção inválida! Tente novamente");
                menu(arvore);
            }
        }
    }
    public void func_ExibirArvore(Arvore arvore, int opcao){
        switch (opcao) {
            case 1 -> {
                System.out.println("/////////////");
                arvore.percorrerInOrdem(arvore.raiz);
                System.out.println("/////////////");
                arvore.imprimirGraficamente(System.out);
                System.out.println("/////////////");
            }
            case 2 -> {
                System.out.println("/////////////");
                arvore.percorrerPreOrdem(arvore.raiz);
                System.out.println("/////////////");
                arvore.imprimirGraficamente(System.out);
                System.out.println("/////////////");
            }
            case 3 -> {
                System.out.println("/////////////");
                arvore.percorrerPosOrdem(arvore.raiz);
                System.out.println("/////////////");
                arvore.imprimirGraficamente(System.out);
                System.out.println("/////////////");
            }
            case 4 -> {
                System.out.println("/////////////");
                System.out.println("Retornando ao Menu Inicial...");
                System.out.println("/////////////");
                menu(arvore);
            }
            default -> System.out.println("Opção inválida!");
        }
    }
    public void sairOuRetornar(Arvore arvore) {
        System.out.println("[1] Retornar ao Menu \n [2] Sair da Aplicação");
        opcao = entrada.nextInt();
        switch (opcao) {
            case 1 -> menu(arvore);
            case 2 -> {
                System.out.println("Encerrando Aplicação...");
                System.exit(0);
            }
            default -> {
                System.out.println("Opção inválida!");
                sairOuRetornar(arvore);
            }
        }
    }
}
