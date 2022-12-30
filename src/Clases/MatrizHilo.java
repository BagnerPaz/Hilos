package Clases;

public class MatrizHilo extends Thread {

    // Atributos
    private Matriz A, B;
    private int[] res;
    private int x;

    // Constructor
    public MatrizHilo(Matriz A, Matriz B, int x) {
        this.A = A;
        this.B = B;
        this.x = x;
    }

    @Override
    public void run() {
        res = A.multiplicar(B, x);      // Multiplicar fila x de A y columna de B
    }

    public int[] getRes() {
        return res;         // Retorna res
    }

}
