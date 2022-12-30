package Clases;

public class MultiplicarNormal implements Multiplicar {

    // Atributo
    Matriz resultado;

    // Constructor
    public MultiplicarNormal() {
        resultado = new Matriz();
    }

    @Override   // Multiplicación de las matrices A y B
    public void multiplicar(Matriz A, Matriz B) {
        for (int i = 0; i < B.getJ(); i++) {    // Iteración durante el número de columnas de B
            resultado.insertarColumna(A.multiplicar(B, i));     // Multiplicación de fila/columna de A y B
        }
    }

    @Override
    public Matriz getResultado() {
        return resultado;   // Retorna el resultado
    }
}

