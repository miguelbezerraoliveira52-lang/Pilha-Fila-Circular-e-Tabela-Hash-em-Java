public class Main {

    public static void main(String[] args) {
        executarPilha();
        executarFila();
        executarHash();
    }

    private static void executarPilha() {
        System.out.println("PILHA: BASE PARA O TOPO");

        Pilha pilha = new Pilha(6);

        inserirPilha(pilha, 14);
        inserirPilha(pilha, 27);
        inserirPilha(pilha, 35);
        removerPilha(pilha);
        inserirPilha(pilha, 42);
        inserirPilha(pilha, 19);
        removerPilha(pilha);
        inserirPilha(pilha, 50);
        inserirPilha(pilha, 11);
        removerPilha(pilha);
        inserirPilha(pilha, 60);

        System.out.print("Estado final do topo para a base: ");
        pilha.exibirTopoParaBase();

        Pilha copia = pilha.copiar();
        inserirPilha(copia, 75);

        System.out.println("push(75) ocupa a sexta posição, sem overflow.");

        try {
            copia.push(80);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTrês remoções adicionais:");

        removerPilha(pilha);
        removerPilha(pilha);
        removerPilha(pilha);

        System.out.print("Novo estado do topo para a base: ");
        pilha.exibirTopoParaBase();

        Pilha vazia = new Pilha(6);

        try {
            vazia.pop();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void inserirPilha(Pilha pilha, int valor) {
        pilha.push(valor);
        System.out.print("push(" + valor + "): ");
        pilha.exibir();
    }

    private static void removerPilha(Pilha pilha) {
        int removido = pilha.pop();
        System.out.print("pop() removeu " + removido + ": ");
        pilha.exibir();
    }

    private static void executarFila() {
        System.out.println("\nFILA CIRCULAR: INÍCIO PARA O FIM");

        FilaCircular fila = new FilaCircular(5);

        inserirFila(fila, "Ana");
        inserirFila(fila, "Bruno");
        inserirFila(fila, "Carlos");
        removerFila(fila);
        inserirFila(fila, "Daniela");
        inserirFila(fila, "Eduardo");
        inserirFila(fila, "Fernanda");
        removerFila(fila);
        inserirFila(fila, "Gustavo");

        System.out.println("Início: " + fila.consultarInicio());
        System.out.println("Fim: " + fila.consultarFim());

        System.out.print("Estado final: ");
        fila.exibir();

        try {
            fila.enqueue("Henrique");
        } catch (IllegalStateException e) {
            System.out.println("enqueue(Henrique): " + e.getMessage());
        }
    }

    private static void inserirFila(FilaCircular fila, String cliente) {
        fila.enqueue(cliente);
        System.out.print("enqueue(" + cliente + "): ");
        fila.exibir();
    }

    private static void removerFila(FilaCircular fila) {
        String removido = fila.dequeue();
        System.out.print("dequeue() removeu " + removido + ": ");
        fila.exibir();
    }

    private static void executarHash() {
        System.out.println("\nTABELA HASH");

        TabelaHash tabela = new TabelaHash(10);
        int[] valores = {15, 25, 35, 18, 28, 38, 44, 54, 64};

        for (int valor : valores) {
            int posicao = tabela.hash(valor);
            boolean colisao = tabela.inserir(valor);

            System.out.println("h(" + valor + ") = " + posicao + (colisao ? " - Houve colisão." : " - Sem colisão."));
        }

        System.out.println("\nTabela final:");
        tabela.exibir();

        System.out.println("\nPosições com mais elementos:");
        tabela.exibirMaioresListas();

        System.out.println("Total de colisões: " + tabela.getColisoes());
        System.out.println("Fator de carga: " + tabela.fatorCarga());

        System.out.println("Buscar 28: " + tabela.buscar(28));
        System.out.println("Buscar 99: " + tabela.buscar(99));
    }
}