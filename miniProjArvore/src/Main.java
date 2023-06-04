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





        Aluno aluno = new Aluno(7, "Marcos");
        Aluno aluno1 = new Aluno(8, "Dani");
        arvoreBinaria.adicionarNo(aluno);
        arvoreBinaria.adicionarNo(aluno1);


        arvoreBinaria.percorrerInOrdem(arvoreBinaria.raiz);

        arvoreBinaria.remover(arvoreBinaria.raiz, aluno);

        System.out.println();
        System.out.println("/////////////APÓS A REMOÇÃO/////////////");
        System.out.println();
        arvoreBinaria.percorrerInOrdem(arvoreBinaria.raiz);


        Menu.menu(arvoreBinaria);



    }
}