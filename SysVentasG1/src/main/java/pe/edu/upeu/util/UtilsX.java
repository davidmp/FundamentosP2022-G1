package pe.edu.upeu.util;

import java.net.URL;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class UtilsX {
    public int fibonaciRecur(final int numero) {
        if (numero < 2) {
            return numero;
        } else {
            return fibonaciRecur(numero - 1) + fibonaciRecur(numero - 2);
        }
    }

    public URL getFile(String ruta) {
        return this.getClass().getResource("/" + ruta);
    }

    public TableModel reporData() {
        return null;
    }

    public final void clearConsole(){
        try{            
            final String os = System.getProperty("os.name");    
            if (os.contains("Windows")){
               new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
            }
        }
        catch (final Exception e){
           System.out.println("Error: "+e.getMessage());
        }
       System.out.println("------------------------------------------------"); 
    }  

    public static void pintarLine(char horient, int sizen) {
        for (int i = 0; i <= (sizen); i++) {
            if (horient=='H') {
                if(i==sizen){
                    System.out.print("-");
                }else{System.out.print("--");}
                
            } else {
                System.out.print("|");
            }
        }
        if (horient=='H') {
            System.out.print("\n");
        }
    }

    public static void pintarTextHeadBody(char type, int sizen, String content) {
        
        int sizeX=sizen>=2?4*sizen:4;
        System.out.print("|");
        String[] data=content.split(",");        
        for (int j = 1; j <= data.length; j++) {
            data[j-1]=data[j-1].length()>sizeX?data[j-1].substring(0,sizeX):data[j-1];            
            int contentSize=data[j-1].length();
            System.out.print(data[j-1]);         
            if(sizeX-contentSize>=4 && (double)(sizeX-contentSize)/4>=1){
                int y=(int)((sizeX-contentSize)/4);
                //System.out.print("y*"+y); 
                for (int i = 0; i <y; i++) {
                    System.out.print("    ");     
                }
                int x=((sizeX-contentSize)-(y*4));                
                //System.out.print("z*"+x); 
                for (int i = 0; i < x; i++) {
                    System.out.print(" "); 
                }                 
            }else{
                int x=((sizeX-contentSize)-((int)((sizeX-contentSize)/4)*4));
                //System.out.print("x*"+x); 
                for (int i = 0; i < x; i++) {
                    System.out.print(" "); 
                }
            }           
            System.out.print("|"); 
        }
        if(type!='H'){
            System.out.println("");
        }
        
    }

	/*
	    pintarLine('H', 28);
        pintarTextHeadBody('H', 3, "Nombre,Apellidos,dni,celular");
        System.out.println("");
        pintarLine('H', 28);
        pintarTextHeadBody('B', 3, "David,M,43631917,951782520");
	*/	


}
