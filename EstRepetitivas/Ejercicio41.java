package EstRepetitivas;

import java.util.Scanner;

public class Ejercicio41 {
  
    static Scanner lt=new Scanner(System.in);

    public static void suma10Cantidades41() {
        //Definir variables
        int contador=1;
        double numeroX;
        double sumaNumeros=0;
        //Proceso Datos de entrada
        while (contador<=10) {
            System.out.print("Ingrese el valor de "+contador+": ");
            numeroX=lt.nextDouble();
            sumaNumeros=sumaNumeros+numeroX;
            contador++;
            System.out.println("");
        }
        //Datos de Salida
        System.out.println("La suma de los "+(contador-1)+" valores introducidos es: "+ sumaNumeros);
    }


    public static void main(String[] args) {
        suma10Cantidades41();
    }

}
