import java.io.PrintStream;

public class Arvore {
    No raiz;

    //Métodos de Adicionar Nós
    private No adicionarNoRecursivo(No atual, Aluno aluno) {
        //Se o nó raíz é nulo, cria um novo nó raíz
        if (atual == null) {
            return new No(aluno);
        }

        //Insere o nó no local apropriado para árvores com raíz existente
        if (aluno.getRgm() < atual.aluno.getRgm()) {
            atual.esquerda = adicionarNoRecursivo(atual.esquerda, aluno);
        } else if (aluno.getRgm() > atual.aluno.getRgm()) {
            atual.direita = adicionarNoRecursivo(atual.direita, aluno);
        } else {
            System.out.println("O RGM informado já existe.");
        }

        return atual;
    }

    public void adicionarNo(Aluno aluno) {
        //Sobrescreve a árvore com a nova árvore gerada no método
        raiz = adicionarNoRecursivo(raiz, aluno);
    }

    //Métodos de Percorrer e Exibir Árvore

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

    private String graficoPreOrdem(No raiz) {
        //Se a raiz for null, não tem árvore para exibir.
        if(raiz == null) {
            return "";
        }

        //Criando um StringBuilder que vai exibir a árvore por completo no método final
        StringBuilder sb = new StringBuilder();
        sb.append("RGM: ");
        sb.append(raiz.aluno.getRgm());
        sb.append(" - Nome: ");
        sb.append(raiz.aluno.getNome());

        //Criando Strings para passar como parâmetro
        String apontadorDireita = "└──";
        String apontadorEsquerda = (raiz.direita != null) ? "├──" : "└──";

        //Adicionando os nós abaixo da raíz em nosso StringBuilder
        leitorDeNos(sb, "", apontadorEsquerda, raiz.esquerda, raiz.direita != null);
        leitorDeNos(sb, "", apontadorDireita, raiz.direita, false);

        return sb.toString();
    }

    private void leitorDeNos(StringBuilder sb, String padding, String apontador, No no, Boolean temNoDireita) {
        if(no != null) {
            //Criando a String que aparecerá na linha atual
            sb.append("\n");
            sb.append(padding);
            sb.append(apontador);
            sb.append("RGM: ");
            sb.append(no.aluno.getRgm());
            sb.append(" - Nome: ");
            sb.append(no.aluno.getNome());

            //Preparando os argumentos para a criação da próxima linha
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
        //Usando PrintStream com System.out para exibir nossa String no console
        impressor.print(graficoPreOrdem(this.raiz));
        System.out.println();
    }

    //Métodos para Remoção e Apagar Árvore
    public No remover(No atual, Aluno aluno) {

        //O nó atual não existe
        if (atual == null) {
            return null;
        }

        //O RGM do nó atual é equivalente ao RGM informado
        if (aluno.getRgm() == atual.aluno.getRgm()) {
            // Caso Especial: A raiz é o nó a ser removido e não tem nó à esquerda ou direita
            if (this.raiz.aluno.getRgm() == aluno.getRgm()) {
                if (this.raiz.direita == null) {
                    this.raiz = this.raiz.esquerda;
                    return null;
                }
                if (this.raiz.esquerda == null) {
                    this.raiz = this.raiz.direita;
                    return null;
                }
            }

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

        //O RGM do nó atual é menor que RGM informado
        if (aluno.getRgm() < atual.aluno.getRgm()) {
            atual.esquerda = remover(atual.esquerda, aluno);
            return atual;
        }

        //O RGM do nó atual é maior que RGM informado
        atual.direita = remover(atual.direita, aluno);
        return atual;
    }

    private Aluno acharSucessor(No raiz) {
        //Encontra o menor RGM a partir da raíz da subárvore informada
        return raiz.esquerda == null ? raiz.aluno : acharSucessor(raiz.esquerda);
    }

    public void apagarArvore() {
        //Apaga todos os nós
        apagarNo(this.raiz);
        this.raiz = null;
    }

    private void apagarNo(No no) {
        if (no != null) {
            //Percorre a árvore pós-ordem e deleta os dados de cada nó individualmente
            apagarNo(no.esquerda);
            apagarNo(no.direita);
            no.aluno = null;
            no.direita = null;
            no.esquerda = null;
        }
    }

    //Método de Buscar RGM
    public String buscarAluno(No atual, int matricula) {
        //Se o nó atual for null, retorna null
        if (atual == null) {
            return null;
        }

        //Caso o nó seja igual, retorna o nome do aluno
        //Caso não seja igual, usamos a recorrência para percorrer a árvore até o final ou até achar uma equivalência
        if (atual.aluno.getRgm() == matricula) {
            return atual.aluno.getNome();
        } else if (matricula < atual.aluno.getRgm()) {
            return buscarAluno(atual.esquerda, matricula);
        } else {
            return buscarAluno(atual.direita, matricula);
        }
    }
}




