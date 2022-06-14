package pe.edu.upeu.arrays;

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

    public static void main(String[] args) {
        VectoresEjemplo objx=new VectoresEjemplo();
        objx.vectoresX();

       //new VectoresEjemplo().vectoresX();
    }

}