public class TabelaHash {

    private final No[] tabela;
    private int quantidade;
    private int colisoes;

    public TabelaHash(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade inválida.");
        }

        tabela = new No[capacidade];
        quantidade = 0;
        colisoes = 0;
    }

    public int hash(int valor) {
        int posicao = valor % tabela.length;

        // Ajusta o índice caso o valor seja negativo.
        if (posicao < 0) {
            posicao += tabela.length;
        }

        return posicao;
    }

    public boolean inserir(int valor) {
        int posicao = hash(valor);
        No novo = new No(valor);
        boolean houveColisao = tabela[posicao] != null;

        if (!houveColisao) {
            tabela[posicao] = novo;
        } else {
            colisoes++;

            No atual = tabela[posicao];

            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }

            atual.setProximo(novo);
        }

        quantidade++;
        return houveColisao;
    }

    public boolean buscar(int valor) {
        int posicao = hash(valor);
        No atual = tabela[posicao];

        while (atual != null) {
            if (atual.getValor() == valor) {
                return true;
            }

            atual = atual.getProximo();
        }

        return false;
    }

    public int getColisoes() {
        return colisoes;
    }

    public double fatorCarga() {
        return (double) quantidade / tabela.length;
    }

    private int contarElementos(int posicao) {
        int total = 0;
        No atual = tabela[posicao];

        while (atual != null) {
            total++;
            atual = atual.getProximo();
        }

        return total;
    }

    public void exibirMaioresListas() {
        int maior = 0;

        for (int i = 0; i < tabela.length; i++) {
            int total = contarElementos(i);

            if (total > maior) {
                maior = total;
            }
        }

        if (maior == 0) {
            System.out.println("Tabela vazia.");
            return;
        }

        for (int i = 0; i < tabela.length; i++) {
            if (contarElementos(i) == maior) {
                System.out.println(
                        "Posição " + i + ": " + maior + " elementos."
                );
            }
        }
    }

    public void exibir() {
        for (int i = 0; i < tabela.length; i++) {
            System.out.print(i + ": ");

            No atual = tabela[i];

            while (atual != null) {
                System.out.print(atual.getValor() + " -> ");
                atual = atual.getProximo();
            }

            System.out.println("null");
        }
    }
}