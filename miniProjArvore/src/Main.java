import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Aluno> alunosTxt = TextReader.readTxt();
        Arvore arvoreBinaria = new Arvore();
        for(Aluno aluno : alunosTxt) {
            arvoreBinaria.adicionarNo(aluno);
        }

        arvoreBinaria.percorrerInOrdem(arvoreBinaria.raiz);
        System.out.println();
        arvoreBinaria.percorrerPreOrdem(arvoreBinaria.raiz);
        System.out.println();
        arvoreBinaria.percorrerPosOrdem(arvoreBinaria.raiz);

        Aluno novoTeste = new Aluno(7, "Marcos");
        arvoreBinaria.adicionarNo(novoTeste);

        System.out.println();
        arvoreBinaria.percorrerInOrdem(arvoreBinaria.raiz);
        System.out.println();

        arvoreBinaria.remover(arvoreBinaria.raiz, novoTeste);

        System.out.println();
        arvoreBinaria.percorrerInOrdem(arvoreBinaria.raiz);

    }
}