import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList<Aluno> alunosTxt = TextReader.readTxt();
        Arvore arvoreBinaria = new Arvore();
        for(Aluno aluno : alunosTxt) {
            arvoreBinaria.adicionarNo(aluno);
        }

        Aluno aluno = new Aluno(7, "Marcos");
        Aluno aluno1 = new Aluno(8, "Dani");
        arvoreBinaria.adicionarNo(aluno);
        arvoreBinaria.adicionarNo(aluno1);

       Menu menu = new Menu();
        menu.menu(arvoreBinaria);






    }
}