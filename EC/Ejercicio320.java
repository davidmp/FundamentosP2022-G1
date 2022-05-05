package EC;

import java.util.Scanner;

/**
 * Ejercicio320
 */
public class Ejercicio320 {

    public static void main(String[] args) {
        //Declarar variables
        int talla;
        double cantTela, costoTela, cantPant,pbase=0,utilUni, pfinal, utilTotal, cantTP;
        String modelo;
        //Datos de Entrada
        Scanner lt=new Scanner(System.in);
        System.out.println("Ingrese Modelo:");
        modelo=lt.next();
        System.out.println("Ingrese Talla a confeccionar:");
        talla=lt.nextInt();
        System.out.println("Cantidad Tela:");
        cantTela=lt.nextDouble();
        System.out.println("Costo Tela x Mt:");
        costoTela=lt.nextDouble();   
        System.out.println("Mt Tela x Pantalon:");
        cantTP=lt.nextDouble();
        //Proceso
        cantPant=Math.round(cantTela/cantTP); 
        if (modelo.equals("A")) {
            if (talla==32 || talla==36 ) {
                pbase=costoTela+costoTela*0.80+costoTela*0.04;
            }else{
                pbase=costoTela+costoTela*0.80;
            }            
        } else {
            if (talla==32 || talla==36 ) {
                pbase=costoTela+costoTela*0.95+costoTela*0.04;
            }else{
                pbase=costoTela+costoTela*0.95;
            }            
        }
        utilUni=pbase*0.30;
        pfinal=utilUni+pbase;
        utilTotal=utilUni*cantPant;
        //Datos de Salida
        System.out.println("Precio de cada Pantalon: "+pfinal);
        System.out.println("Utilidad Total : "+utilTotal);
    }
}