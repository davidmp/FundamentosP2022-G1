package pe.edu.upeu.arrays;

import java.util.Scanner;

public class Transformadas {
    Scanner cs=new Scanner(System.in);

    public void transformada01() {
        System.out.println("Ingrese dimesion de Matriz:");
        int dimension=cs.nextInt();
        System.out.println("Ingrese valor inicial:");
        int valor=cs.nextInt();            
        String[][] matriz=new String[dimension][dimension];
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz.length; c++) {
                if(c<dimension-f){
                    matriz[f][c]=String.valueOf(valor+(f+c)*(f+c+1)/2 + f);
                }                
            }
        }
        imprimirMatriz(matriz);
    }

    public void imprimirMatriz(String[][] m) {
        for (int f = 0; f < m.length; f++) {
            for (int c = 0; c < m[0].length; c++) {
                if(m[f][c]==null){
                    System.out.print("\t");
                }else{
                    System.out.print(m[f][c]+"\t");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        new Transformadas().transformada01();
    }

}
