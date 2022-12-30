package Clases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // Definición de variables
        Matriz A, B;
        int m, n, p, num;
        long inicio, tiempo;

        System.out.print("Ingrese el valor de m: ");    // Ingreso de los tamaños de las matrices
        m = sc.nextInt();
        System.out.print("Ingrese el valor de n: ");
        n = sc.nextInt();
        System.out.print("Ingrese el valor de p: ");
        p = sc.nextInt();

        A = new Matriz(m, n);       // Definición de las matrices con sus tamaños
        B = new Matriz(n, p);

        System.out.println("\n");

        for (int i = 0; i < A.getI(); i++) {        // Ingreso de datos en las matrices
            for (int j = 0; j < A.getJ(); j++) {
                System.out.printf("Ingrese el valor de A[%dx%d]:", i, j);
                num = sc.nextInt();
                A.setNum(num, i, j);
            }
        }

        System.out.println();

        for (int i = 0; i < B.getI(); i++) {
            for (int j = 0; j < B.getJ(); j++) {
                System.out.printf("Ingrese el valor de B[%dx%d]:", i, j);
                num = sc.nextInt();
                B.setNum(num, i, j);
            }
        }

        System.out.println("\n\nMatriz A:\n" + A + "\nMatriz B:\n" + B);        // Imprime las matrices

        // Declaración de los dos tipos de multiplicación (monohilo y multihilo)
        Multiplicar mHilos = new MultiplicarHilos(), mNormal = new MultiplicarNormal();

        inicio = System.nanoTime();             // Obtención del tiempo inicial
        mNormal.multiplicar(A, B);              // Multiplicación de las matrices en monohilo
        tiempo = System.nanoTime() - inicio;    // Calculo de la duración total de la multiplicación
        System.out.printf("Resultado sin hilos (%d nanosegundos):\n" + mNormal.getResultado(), tiempo);

        inicio = System.nanoTime();             // Obtención del tiempo inicial
        mHilos.multiplicar(A, B);               // Multiplicación de las matrices en multihilo
        tiempo = System.nanoTime() - inicio;    // Calculo de la duracion total de la multiplicación
        System.out.printf("\nResultado con hilos (%d nanosegundos):\n" + mHilos.getResultado(), tiempo);
    }
}
