

import java.util.Scanner;

/**
 * Ejercicio35
 */
public class Ejercicio35 {
    static Scanner lt=new Scanner(System.in);
    public static void main(String[] args) {
       //Declarar Variables
       String nombre1, nombre2, nombre3, menorpersona;
       int edad1,  edad2, edad3, menoredad;
       //Datos de entrada
       System.out.println("Ingrese nombre 1:");
        nombre1=lt.next();
       System.out.println("Ingrese edad de persona 1:");
       edad1=lt.nextInt();
       System.out.println("Ingrese nombre 2:");
        nombre2=lt.next();
       System.out.println("Ingrese edad de persona 2:");
       edad2=lt.nextInt();
       System.out.println("Ingrese nombre 3:");
        nombre3=lt.next();
       System.out.println("Ingrese edad de persona 3:");
       edad3=lt.nextInt();              
        //Proceso
        if (edad1<edad2 && edad1<edad3) {
            menoredad=edad1;
            menorpersona=nombre1;
        } else if(edad2<edad1 && edad2<edad3){
            menoredad=edad2;
            menorpersona=nombre2;
        }else{
            menoredad=edad3;
            menorpersona=nombre3;          
        }
        //Datos de Salida
        System.out.println("La persona con menor edad es: "+menoredad+" y se llama "+menorpersona);

    }
}