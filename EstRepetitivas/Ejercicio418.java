package EstRepetitivas;

import java.util.Scanner;

/**
 * Ejercicio418
 */
public class Ejercicio418 {

    static Scanner lt=new Scanner(System.in);

    public static void impuestoVehiculo418() {
        //Definir variables
        String cateV="";
        int cantidad=0;
        double costV=0, impUnit=0, impTotal=0, totalImpV=0;
        //Datos de Entrada y Proceso y Salida
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese Cantidad Vehiculos de Categoria "+(i+1)+": ");
            cantidad=lt.nextInt();
            System.out.println("Ingrese el precio de la categoria "+(i+1)+":");
            costV=lt.nextDouble();
            if(i==0){
                impUnit=costV*0.10;                
            }else if(i==1){
                impUnit=costV*0.07;
            }else{
                impUnit=costV*0.05;
            }            
            impTotal=impUnit*cantidad;
            System.out.println("Impuesto de Categoria "+(i+1)+" es:"+impUnit);
            System.out.println("Impuesto Total de Categoria "+(i+1)+" es:"+impTotal);
            totalImpV=totalImpV+impTotal;
        }
        System.out.println("Impuesto Total de los Vehiculos es :"+totalImpV);
    }
    public static void main(String[] args) {
        impuestoVehiculo418();
    }
}