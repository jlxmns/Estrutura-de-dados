import java.io.PrintStream;

public class Arvore {
    No raiz;

    //Essa função é privada e serve para adicionar o nó seguindo a regra da ABB
    private No adicionarNoRecursivo(No atual, Aluno aluno) {
        //Se o nó atual for Null, criamos um novo nó com o dado (aluno)
        if (atual == null) {
            return new No(aluno);
        }

        /* Se o rgm do nó que queremos adicionar for MENOR que o rgm do nó atual,
         * chamamos a função novamente, mas dessa vez passando o nó do lado esquerdo
         * do nó original (o raíz) */
        if (aluno.getRgm() < atual.aluno.getRgm()) {
            atual.esquerda = adicionarNoRecursivo(atual.esquerda, aluno);
        }
        /* se o rgm do nó que queremos adicionar for MAIOR que o rgm do nó atual,
         * chamamos a função novamente, mas dessa vez passando o nó do lado direito
         * do nó original */
        else if (aluno.getRgm() > atual.aluno.getRgm()) {
            atual.direita = adicionarNoRecursivo(atual.direita, aluno);
        } else {
            throw new IllegalArgumentException("O RGM informado já existe.");
        }
        return atual;
    }

    public void adicionarNo(Aluno aluno) {
        raiz = adicionarNoRecursivo(raiz, aluno);
    }

    public void percorrerInOrdem(No no) {
        if (no != null) {
            percorrerInOrdem(no.esquerda);
            System.out.println("RGM: " + no.aluno.getRgm() + " Nome: " + no.aluno.getNome());
            percorrerInOrdem(no.direita);
        }

    }

    public void percorrerPreOrdem(No no) {
        if (no != null) {
            System.out.println("RGM: " + no.aluno.getRgm() + " Nome: " + no.aluno.getNome());
            percorrerInOrdem(no.esquerda);
            percorrerInOrdem(no.direita);
        }
    }

    public void percorrerPosOrdem(No no) {
        if (no != null) {
            percorrerInOrdem(no.esquerda);
            percorrerInOrdem(no.direita);
            System.out.println("RGM: " + no.aluno.getRgm() + " Nome: " + no.aluno.getNome());
        }

    }


    //Função para remoção de UM elemento
    public No remover(No atual, Aluno aluno) {


        if (atual == null) { //Não há nó a ser removido
            System.out.println("Não há nó a ser removido");
            return null;
        }

        if (aluno.getRgm() == atual.aluno.getRgm()) {
            // Caso 1: Remoção de um nó folha
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            // Caso 2: Remoção de um nó com apenas 1 filho
            if (atual.direita == null) {
                return atual.esquerda;
            }

            if (atual.esquerda == null) {
                return atual.direita;
            }

            // Caso 3 Remoção de um nó com 2 filhos
            Aluno sucessor = acharSucessor(atual.direita);
            atual.aluno = sucessor;
            atual.direita = remover(atual.direita, sucessor);
            return atual;
        }

        if (aluno.getRgm() < atual.aluno.getRgm()) { //O RGM informado é menor
            atual.esquerda = remover(atual.esquerda, aluno);
            return atual;
        }

        atual.direita = remover(atual.direita, aluno);
        return atual;
    }

    private Aluno acharSucessor(No raiz) {
        return raiz.esquerda == null ? raiz.aluno : acharSucessor(raiz.esquerda);
    }

    public boolean contemNo(No atual, Aluno aluno) {
        if (atual == null) {
            return false;
        }
        if (aluno.getRgm() == atual.aluno.getRgm()) {
            return true;
        }
        return aluno.getRgm() < atual.aluno.getRgm()
                ? contemNo(atual.esquerda, aluno)
                : contemNo(atual.direita, aluno);
    }

    public static String buscarAluno(No atual, int matricula) {
        if (atual == null || atual.aluno.getRgm() == matricula) {
            if (atual != null) {
                return atual.aluno.getNome();
            } else {
                return null;
            }
        } else if (matricula < atual.aluno.getRgm()) {
            return buscarAluno(atual.esquerda, matricula);
        } else {
            return buscarAluno(atual.direita, matricula);
        }


    }

    private String graficoPreOrdem(No raiz) {
        if(raiz == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("RGM: ");
        sb.append(raiz.aluno.getRgm());
        sb.append(" - Nome: ");
        sb.append(raiz.aluno.getNome());

        String apontadorDireita = "└──";
        String apontadorEsquerda = (raiz.direita != null) ? "├──" : "└──";

        leitorDeNos(sb, "", apontadorEsquerda, raiz.esquerda, raiz.direita != null);
        leitorDeNos(sb, "", apontadorDireita, raiz.direita, false);

        return sb.toString();
    }

    private void leitorDeNos(StringBuilder sb, String padding, String apontador, No no, Boolean temNoDireita) {
        if(no != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(apontador);
            sb.append("RGM: ");
            sb.append(no.aluno.getRgm());
            sb.append(" - Nome: ");
            sb.append(no.aluno.getNome());

            StringBuilder construtorDePadding = new StringBuilder(padding);
            if(temNoDireita) {
                construtorDePadding.append("│  ");
            } else {
                construtorDePadding.append("   ");
            }

            String paddingAmbos = construtorDePadding.toString();
            String apontadorDireita = "└──";
            String apontadorEsquerda = (no.direita != null) ? "├──" : "└──";

            leitorDeNos(sb, paddingAmbos, apontadorEsquerda, no.esquerda, no.direita != null);
            leitorDeNos(sb, paddingAmbos, apontadorDireita, no.direita, false);
        }
    }

    public void imprimirGraficamente(PrintStream impressor) {
        impressor.print(graficoPreOrdem(this.raiz));
        System.out.println("");
    }
}




