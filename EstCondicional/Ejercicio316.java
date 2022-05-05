
import java.util.Scanner;

public class Ejercicio316 {
    static Scanner lt=new Scanner(System.in);
    public static void main(String[] args) {
        //Declarar Variables
        int puntos;
        double bono=0, sueldoMin;
        //Datos de entrada
        System.out.println("Ingrese la puntuacion del docente:");
        puntos=lt.nextInt();
        System.out.println("Ingrese el sueldo minimo:");
        sueldoMin=lt.nextDouble();
        //Proceso
        if (puntos>=0 && puntos<=100) {
            bono=sueldoMin;
        } else if( puntos>=101 && puntos<=150){
            bono=2*sueldoMin;
        }else if(puntos>=151){
            bono=3*sueldoMin;
        }
        //Datos de salida
        System.out.println("El Bono que obtendra el profesor es: "+bono);
    }
}
