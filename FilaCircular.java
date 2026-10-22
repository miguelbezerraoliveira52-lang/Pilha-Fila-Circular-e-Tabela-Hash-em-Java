public class FilaCircular {

    private final String[] elementos;
    private int inicio;
    private int fim;
    private int quantidade;

    public FilaCircular(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade inválida.");
        }

        elementos = new String[capacidade];
        inicio = 0;
        fim = -1;
        quantidade = 0;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }

    public boolean estaCheia() {
        return quantidade == elementos.length;
    }

    public int tamanho() {
        return quantidade;
    }

    public void enqueue(String cliente) {
        if (estaCheia()) {
            throw new IllegalStateException("Overflow: fila cheia.");
        }

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }

        fim = (fim + 1) % elementos.length;
        elementos[fim] = cliente;
        quantidade++;
    }

    public String dequeue() {
        if (estaVazia()) {
            throw new IllegalStateException("Underflow: fila vazia.");
        }

        String removido = elementos[inicio];
        elementos[inicio] = null;

        inicio = (inicio + 1) % elementos.length;
        quantidade--;

        return removido;
    }

    public String consultarInicio() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia.");
        }

        return elementos[inicio];
    }

    public String consultarFim() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia.");
        }

        return elementos[fim];
    }

    public void exibir() {
        System.out.print("[");

        for (int i = 0; i < quantidade; i++) {
            int posicao = (inicio + i) % elementos.length;

            if (i > 0) {
                System.out.print(", ");
            }

            System.out.print(elementos[posicao]);
        }

        System.out.print("]");

        if (!estaVazia()) {
            System.out.print(" | índice início: " + inicio + " | índice fim: " + fim);
        }

        System.out.println();
    }
}