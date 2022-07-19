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

    public void transformada17() {
        System.out.println("Ingrese dimesion de Matriz:");
        int dimension=cs.nextInt();
        System.out.println("Ingrese valor inicial:");
        int valor=cs.nextInt();            
        String[][] matriz=new String[dimension][dimension];   
        for (int c = matriz[0].length-1; c >=0 ; c--) {
            for (int f =0 ; f < matriz.length-((dimension-1)-c); f++) {               
                matriz[f][c]=String.valueOf(valor);
                valor++;
            }
        }        
        imprimirMatriz(matriz);
    }

    public void transformada21() {
       String[][] matriz;
       System.out.println("Ingrese la dimension de la Matriz:");
       int dimension=cs.nextInt();//5
       System.out.println("");
       int valor=0;
       matriz=new String[dimension][dimension];
       for (int columna = 0; columna < matriz[0].length; columna++) {
           if(columna%2==0){
                for (int fila = 0; fila < matriz.length; fila++) {
                    matriz[fila][columna]=String.valueOf(valor);
                    valor=valor+1;
                }
           }else{
               for (int fila = matriz.length-1; fila >= 0; fila--) {
                    matriz[fila][columna]=String.valueOf(valor);
                    valor=valor+1;
               }
           }
       }
       imprimirMatriz(matriz);
    }

    public void transformada29() {
        String[][] matriz;
        System.out.println("Ingrese la dimension de la Matriz:");
        int dimension=cs.nextInt();//5
        System.out.println("");
        int valor=0;
        matriz=new String[dimension][dimension];         
        for (int v = 0; v < dimension/2; v++) {
            for (int ls = v; ls < dimension-1-v; ls++) {
                matriz[v][ls]=String.valueOf(valor);
                valor++;
            }
            for (int ld = v; ld < dimension-1-v; ld++) {
                matriz[ld][dimension-1-v]=String.valueOf(valor);
                valor++;
            }
            for (int lin = dimension-1-v; lin > v; lin--) {
                matriz[dimension-1-v][lin]=String.valueOf(valor);
                valor++;
            }
            for (int liz =dimension-1-v; liz > v; liz--) {
                matriz[liz][v]=String.valueOf(valor);
                valor++;
            }            
        }
        if (dimension%2!=0) {
            matriz[dimension/2][dimension/2]=String.valueOf(valor);
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
        //new Transformadas().transformada01();
        new Transformadas().transformada29();
    }

}
