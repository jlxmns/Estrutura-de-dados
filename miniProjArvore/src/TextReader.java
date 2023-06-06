import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextReader {
    public static ArrayList<Aluno> readTxt() {
        //BufferedReader é uma classe com métodos interessantes para leitura de arquivos
        BufferedReader reader;
        ArrayList<Aluno> arrayAlunos = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("src/alunos.txt"));
            //Variável linha inicializada com a linha inicial do arquivo
            //Cada vez que é invocado, o readLine() vai para a próxima linha do arquivo txt
            String line = reader.readLine();

            while (line != null) {
                //Criando novo aluno usando 2 linhas do arquivo txt
                Aluno aux = new Aluno();
                aux.setRgm(Integer.parseInt(line));
                line = reader.readLine();
                aux.setNome(line);

                //Adicionando esse aluno à nossa ArrayList de alunos
                arrayAlunos.add(aux);

                //Pulando para a próxima linha para a próxima execução do loop
                line = reader.readLine();
            }

            //Fechando nosso leitor de arquivos
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayAlunos;
    }

}