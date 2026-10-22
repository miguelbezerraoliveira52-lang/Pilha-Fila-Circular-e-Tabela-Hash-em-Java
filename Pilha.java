public class Pilha {

    private final int[] elementos;
    private int quantidade;

    public Pilha(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade inválida.");
        }

        elementos = new int[capacidade];
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

    public void push(int valor) {
        if (estaCheia()) {
            throw new IllegalStateException("Overflow: pilha cheia.");
        }

        elementos[quantidade] = valor;
        quantidade++;
    }

    public int pop() {
        if (estaVazia()) {
            throw new IllegalStateException("Underflow: pilha vazia.");
        }

        quantidade--;
        return elementos[quantidade];
    }

    public Pilha copiar() {
        Pilha copia = new Pilha(elementos.length);

        for (int i = 0; i < quantidade; i++) {
            copia.push(elementos[i]);
        }

        return copia;
    }

    public void exibir() {
        System.out.print("[");

        for (int i = 0; i < quantidade; i++) {
            if (i > 0) {
                System.out.print(", ");
            }

            System.out.print(elementos[i]);
        }

        System.out.println("]");
    }

    public void exibirTopoParaBase() {
        System.out.print("[");

        for (int i = quantidade - 1; i >= 0; i--) {
            System.out.print(elementos[i]);

            if (i > 0) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}