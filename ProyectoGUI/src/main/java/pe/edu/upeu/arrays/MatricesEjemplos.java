package pe.edu.upeu.arrays;

public class MatricesEjemplos {
    
    public void matricesFBasicos() {
        int notas[][];//declarar una matriz
        int [][] notasx;
        notas=new int[2][2];//tamanho/dimension
        notas[0][0]=20;//colocando valores en la matriz
        notas[0][1]=18;
        notas[1][0]=16;
        notas[1][1]=10;
        System.out.println(notas[1][1]);//mostrar nota
        System.out.println("cant filas:"+notas.length);//cantidad filas
        System.out.println("cant columnas:"+notas[0].length);//cantidad columnas

        for (int f = 0; f < notas.length; f++) {//imprime de forma dinamica una matriz
            for (int c = 0; c < notas[0].length; c++) {
                System.out.print(notas[f][c]+"\t");
            }
            System.out.println("");
        }
    }

    public void matricesX() {
        int notas[][] ={
                        {20,18}, 
                        {16,10}
                    };
        notas[1][1]=15;//modificado
        for (int f = 0; f < notas.length; f++) {//imprime de forma dinamica una matriz
            for (int c = 0; c < notas[0].length; c++) {
                System.out.print(notas[f][c]+"\t");
            }
            System.out.println("");
        }
    }
    
    public void sumaMatrices() {
        int[][] A={{-3 , 0},{2,5}, {8,-7}};
        int[][] B={{7 , -5},{4,-2}, {1,-4}};
        int[][] R=new int[A.length][A[0].length];
        for (int f = 0; f < A.length; f++) {
            for (int c = 0; c < B[0].length; c++) {
              R[f][c]=A[f][c]+B[f][c];
            }
        }
        imprimirM(R);
    }
    public void imprimirM(int[][] m) {
        for (int f = 0; f < m.length; f++) {
            for (int c = 0; c < m[0].length; c++) {
                System.out.print(m[f][c]+"\t");
            }
            System.out.println("");
        }        
    }
    public static void main(String[] args) {
        //new MatricesEjemplos().matricesFBasicos();
        //new MatricesEjemplos().matricesX();
        new MatricesEjemplos().sumaMatrices();
    }
}
