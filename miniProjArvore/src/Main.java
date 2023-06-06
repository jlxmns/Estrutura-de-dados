import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Construindo nossa ArrayList de Alunos através do método de leitura de arquivo de texto
        ArrayList<Aluno> alunosTxt = TextReader.readTxt();

        //Loop de for each para adicionar cada aluno individualmente em nossa árvore binária
        Arvore arvoreBinaria = new Arvore();
        for(Aluno aluno : alunosTxt) {
            arvoreBinaria.adicionarNo(aluno);
        }

        //Exibindo o menu
        Menu menu = new Menu();
        menu.menu(arvoreBinaria);
    }
}