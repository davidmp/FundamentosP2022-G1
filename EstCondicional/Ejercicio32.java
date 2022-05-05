

import java.util.Scanner;

public class Ejercicio32 {

    static Scanner lt=new Scanner(System.in);
    public static void main(String[] args) {
        //Declarar Variables
        double pagohora;
        int cantidadhora;
        double sueldosemanal;
        //Datos de entrada
        System.out.println("Ingrese el costo por hora:");
        pagohora=lt.nextDouble();
        System.out.println("Ingrese cantidad horas trabajadas en la semana:");
        cantidadhora=lt.nextInt();
        //Proceso
        if (cantidadhora>40) {
            sueldosemanal=40*pagohora+2*((cantidadhora-40)*pagohora);
        } else {
            sueldosemanal=cantidadhora*pagohora;
        }
        //Datos de salida
        System.out.println("El sueldo del trabajador es "+sueldosemanal);
    }
}
