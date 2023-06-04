public class Aluno {

    private int rgm;
    private String nome;

    public Aluno() {}

    public  Aluno(int rgm){
        this.rgm=rgm;
    }
    public Aluno(int rgm, String nome) {
        this.rgm = rgm;
        this.nome = nome;
    }

    public int getRgm() {
        return rgm;
    }

    public void setRgm(int rgm) {
        this.rgm = rgm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
