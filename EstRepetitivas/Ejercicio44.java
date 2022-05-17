package EstRepetitivas;

import java.util.Scanner;

public class Ejercicio44 {
    static Scanner lt=new Scanner(System.in);

    public static void focosColores44() {
        //Definir Variables
        int cantfocoV=0, cantfocoB=0, cantfocoR=0;
        String colorF="";
        String continuar="S";
        //Datos de entrada y proceso
        while (continuar.equals("S")) {
            System.out.println("Ingrese el color de Foco:\nV=Verde\nB=Blanco\nR-Rojo");
            colorF=lt.next().toUpperCase();
            if (colorF.charAt(0)=='V') {
                cantfocoV++;
            }else if (colorF.charAt(0)=='B') {
                cantfocoB++;
            } else if (colorF.charAt(0)=='R') {
                cantfocoR++;
            }else{
                System.err.println("No es correcto el color de foco");
            }

            System.out.println("Tiene mas focos a evaluar?:\nS=Si\tN=No");
            continuar=lt.next().toUpperCase().equals("S")?"S":"N";
        }
        //Datos de salida
        System.out.println("La cantidad de focos de color Verde es: "+cantfocoV);
        System.out.println("La cantidad de focos de color Blanco es:" +cantfocoB);
        System.out.println("La cantidad de focos de color Rojo es: "+cantfocoR);
        System.out.println("La cantidad Total de focos son: "+(cantfocoV+cantfocoB+cantfocoR));

    }

    public static void main(String[] args) {
        focosColores44();
    }
}
