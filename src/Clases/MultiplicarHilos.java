package Clases;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiplicarHilos implements Multiplicar {

    // Atributo
    Matriz resultado;

    // Constructor
    public MultiplicarHilos() {
        resultado = new Matriz();
    }

    @Override   // Multiplicación de las matrices A y B
    public void multiplicar(Matriz A, Matriz B) {
        MatrizHilo[] hilo = new MatrizHilo[B.getJ()];       // Definición de un arreglo de hilos de tamaño p (# de col de B)
        ExecutorService exe = Executors.newFixedThreadPool(B.getJ());   // Pool que ejecutará los hilos, de tamaño p

        for (int i = 0; i < B.getJ(); i++) {
            hilo[i] = new MatrizHilo(A, B, i);      // Definición de cada hilo y el número de fila/columna a multiplicar
            exe.execute(hilo[i]);                   // Añade el hilo al pool
        }
        exe.shutdown();                      // El pool ya no admitirá más hilos
        while (!exe.isTerminated()) {       // Espera a que todos los hilos hayan terminado
        }

        for (MatrizHilo h : hilo) {                 // Iteración sobre el arreglo de hilos
            resultado.insertarColumna(h.getRes());  // Adición de cada columna al resultado
        }
    }

    @Override
    public Matriz getResultado() {
        return resultado;       // Retorna resultado
    }
}


