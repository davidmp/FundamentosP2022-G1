
import java.util.Scanner;

public class Ejercicio38 {
    static Scanner lt=new Scanner(System.in);
    public static void main(String[] args) {
       //Declarar Variables
        int anhoAnti;
        double sueldo, bonoAnti=0, bonoSueldo, bonoMayor;
        //Datos de entrada
        System.out.println("Ingrese anho de antiguedad:");
        anhoAnti=lt.nextInt();
        System.out.println("Ingrese el sueldo reciente:");
        sueldo=lt.nextDouble();
        //Proceso
        if (sueldo>3500){
        bonoSueldo=sueldo*0.10;
        } else if (sueldo>=1000 && sueldo<=3500){
        bonoSueldo=sueldo*0.15;
        }else{
            bonoSueldo=sueldo*0.25;
        }


      if (bonoAnti>bonoSueldo){
        bonoMayor=bonoAnti;
        }
      else{
        bonoMayor=bonoSueldo;
        }
    //Datos de salida
    System.out.println("El Bono que corresponde es: "+bonoMayor);
    }
}
