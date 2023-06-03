import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextReader {
    //É uma função que vai retornar uma ArrayList de Aluno (cada um com nome e rgm)
    public static ArrayList<Aluno> readTxt() {
        //BufferedReader é uma classe pra tornar mais fácil a leitura do arquivo txt
        //arrayAlunos é nossa variável para armazenar e retornar nossa ArrayList de Aluno
        BufferedReader reader;
        ArrayList<Aluno> arrayAlunos = new ArrayList<>();

        try {
            //reader é a variável que vai ler nosso arquivo, linha por linha.
            //FileReader também é uma classe de leitura, mas usamos métodos apenas do BufferedReader
            reader = new BufferedReader(new FileReader("src/alunos.txt"));
            //line é uma String que vai armazenar a linha atual que pegamos pelo reader
            String line = reader.readLine();

            //loop onde criamos um novo aluno e armazenamos a linha atual como RGM e nome dos alunos
            //também adicionamos esse aluno na nossa ArrayList de alunos
            while (line != null) {
                Aluno aux = new Aluno();
                aux.setRgm(Integer.parseInt(line));
                line = reader.readLine();
                aux.setNome(line);
                arrayAlunos.add(aux);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayAlunos;
    }

}