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
        if (atual == null) {
                return null;
            }

            if (aluno.getRgm()== atual.aluno.getRgm()) {
                atual.aluno.setNome(null);
                atual.aluno.setRgm(0);
            }
            if (aluno.getRgm()< atual.aluno.getRgm()) {
                atual.esquerda = remover(atual.esquerda, aluno);
                return atual;
            }
            atual.direita = remover(atual.direita, aluno);
            return atual;
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

    public boolean contemNoRaiz(Aluno aluno) {
        return contemNo(raiz, aluno);
    }
}



