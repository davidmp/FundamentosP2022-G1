package pe.edu.upeu.arrays;

import java.util.Scanner;

import pe.edu.upeu.modelo.Persona;

/**
 * VectoresEjemplo
 */
public class VectoresEjemplo {

    public void vectoresX() {
        int edades[]=new int[10];//forma uno
        edades=new int[12];
        edades[0]=20;
        edades[1]=18;
        edades[11]=30;
        System.out.println("Edades:");
        System.out.println("Indice 0:"+edades[0]);
        System.out.println("Indice 11:"+edades[11]);
        //forma dos
        System.out.println("Forma dos");
        int edadesX[]={20,18,30, 40, 16};
        System.out.println(edadesX.length);
        System.out.println("Indice 0:"+edadesX[0]);
        System.out.println("Indice 4:"+edadesX[4]);        
    }

    public void vectorObjetos() {
        Persona[] p=new Persona[27];
        p[0]=new Persona("43631917", "David", false);
        p[26]=new Persona("43631913", "Dario", false);
        System.out.println(p[26].nombres);

        Persona[] pp={
        new Persona("202012374", "Alejo Castillo Cristhian Brandonlyn	", true),
        new Persona("202212437", "ARCE MAYTA EFRAIN NAYDER	", true),
        new Persona("202212436", "ARCE MAYTA Daniel	", true),
        new Persona("202212435", "ARCE MAYTA Michael	", true),
        new Persona("202212434", "ARCE MAYTA Yesenia	", true),
        };
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < pp.length; i++) {
            System.out.print(pp[i].codigo+"\t"+pp[i].nombres+"\t");
            System.out.println("Presente?");
            pp[i].asistencia=sc.nextBoolean();
            System.out.println("");
        }
        System.out.println("**********************Registro Asistencia************");
        for (int i = 0; i < pp.length; i++) {
            System.out.println(pp[i].codigo+"\t"+pp[i].nombres+"\t"+pp[i].asistencia);
        }
    }

    public static void main(String[] args) {
        VectoresEjemplo objx=new VectoresEjemplo();
        //objx.vectoresX();
        objx.vectorObjetos();
       //new VectoresEjemplo().vectoresX();
    }

}