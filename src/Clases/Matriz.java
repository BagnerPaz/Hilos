package Clases;

public class Matriz {

    // Atributos
    int[][] m;

    // Constructores
    public Matriz() {
        this(0, 0);
    }

    public Matriz(int i, int j) {
        m = new int[i][j];
    }

    // Getters y setters
    public int[][] getM() {
        return m;
    }

    public void setM(int[][] m) {
        this.m = m;
    }

    // Longitud horizontal de la matriz
    public int getI() {
        return m.length;
    }

    // Longitud vertical de la matriz
    public int getJ() {
        return m[0].length;
    }

    // Asignación de un valor en la posicion [i][j]
    public void setNum(int num, int i, int j) {
        m[i][j] = num;
    }

    // Retorno de un valor en la posición [i][j]
    public int getNum(int i, int j) {
        return m[i][j];
    }

    public int[] multiplicar(Matriz B, int x) {
        /* Multiplicación de la fila A[x] y la columna B[][x]
                                    Ejemplo
            Matriz A:           Matriz B:           Resultado:
           | A00 A01 A02 |     | B00 B01 B02 |     | R00 R01 R02 |
           | A10 A11 A12 |     | B10 B11 B12 |     | R10 R11 R12 |
           | A20 A21 A22 |     | B20 B21 B22 |     | R20 R21 R22 |
                                
        R[fila][x] = A[fila][0] * B[0][x] + A[fila][1] * B[1][x] + A[fila][2] * B[2][x]
                
        El algoritmo retorna res y tiene los valores de la columna x de la matriz R:
                    res = {R[0][x], R[1][x], R[2][x]}                
         */
        int[] res = new int[getI()];    // Arreglo en donde se almacenará los resultados
        int[][] m1 = B.getM();      // Obtención del atributo "m" de B
        for (int row = 0; row < getI(); row++) {            // Iteración sobre las filas y columnas
            for (int col = 0; col < getJ(); col++) {
                res[row] += m[row][col] * m1[col][x];   // Suma de la multiplicación de los elementos de A y B
            }
        }
        simularProceso(2);      // Simula un proceso durante 2 segundos
        return res;     // Retorna res
    }

    public void insertarColumna(int[] l) {
        /* Inserta una columnas a la matriz
                                    Ejemplo
            Matriz A:
            | A00 |     insertarColumna(l)    | A00 l0 |
            | A10 |            ->             | A10 l1 |
            
         */
        if (m.length == 0) {
            m = new int[l.length][1];                   // Si la matriz no tiene columnas, redefine m
            for (int row = 0; row < getI(); row++) {    // Iteración sobre los elementos en la columna 
                m[row][0] = l[row];                     // Asignación de los valores
            }
        } else {
            int[][] temp = new int[getI()][getJ() + 1];             // Creación de una matriz temporal de tamaño i, j+1
            for (int row = 0; row < getI(); row++) {                // Copia de cada fila de m en temp
                System.arraycopy(m[row], 0, temp[row], 0, getJ());
            }
            for (int row = 0; row < getI(); row++) {        // Iteración sobre la ultima columna
                temp[row][getJ()] = l[row];                 // Asignación de los valores
            }
            m = temp;       // Asignación de la nueva matriz
        }
    }

    @Override   // Impresión de la matriz
    public String toString() {
        String msg = "";
        for (int row = 0; row < getI(); row++) {
            msg += "|";
            for (int col = 0; col < getJ(); col++) {
                msg += " " + m[row][col];
            }
            msg += " |\n";
        }
        return msg;
    }

    public void simularProceso(int seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}


