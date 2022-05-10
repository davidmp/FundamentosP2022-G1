package EC;

import java.util.Scanner;

public class EjercicioCondMult {
   
    public  void profesor() {
        System.out.println("Enseñar");
    }

    public static void estudiante() {
        System.out.println("Aprender o estudiar");
    }

    public static void maquinaPC() {
        System.out.println("Procesa informacion");
    }

    public static void proyector() {
        System.out.println("Proyecta imagenes");
    }

    public static void main(String[] args) {
        EjercicioCondMult obj=new EjercicioCondMult();
        Scanner lt=new Scanner(System.in);
        System.out.println("Ingrese el numero de algoritmo:\n1=Profesor\n2=Estudainte"+
        "\n3=MaquinaPC\n4=Proyector");
        int opcionMet=lt.nextInt();

        switch (opcionMet) {
            case 1: obj.profesor(); break;
            case 2: obj.estudiante(); break;
            case 3: maquinaPC();break;
            case 4: proyector();break;
            default: System.err.println("Esa opcion no existe"); break;
        }

    }
}
