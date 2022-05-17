package EstRepetitivas;

import java.util.Scanner;

public class Ejercicio47 {
    static Scanner lt=new Scanner(System.in);

    public static void numMayoresCeroMenores47() {
        //Definir Variables
        int cantNumMayorcero=0, cantNumMenorIgualCero=0;
        double numN=0;
        String continuar="S";
        //Datos de entrada y proceso
        while (continuar.equals("S")) {
            System.out.println("Ingrese un numero:");
            numN=lt.nextDouble();
            if (numN<=0) {
                cantNumMenorIgualCero++;
            }else{
                cantNumMayorcero++;
            }
            System.out.println("Desea ingresar mas numeros?:\nS=Si\tN=No");
            continuar=lt.next().toUpperCase().equals("S")?"S":"N";
        }  
        //Datos de salida
        System.out.println("Cantidad de numeros Mayores de cero: "+cantNumMayorcero);
        System.out.println("Cantidad de numeros menores e iguales a cero: "+cantNumMenorIgualCero);
        System.out.println("Total de numeros introducidos: "+(cantNumMayorcero+cantNumMenorIgualCero));

    }

    public static void main(String[] args) {
        numMayoresCeroMenores47();
    }
}
