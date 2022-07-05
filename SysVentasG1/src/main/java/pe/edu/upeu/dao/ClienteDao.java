package pe.edu.upeu.dao;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.ClienteTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;

public class ClienteDao extends AppCrud{
    LeerTeclado leerT=new LeerTeclado();
    LeerArchivo leerA; 
    UtilsX util=new UtilsX();
    ClienteTO cTo;
    final static String TABLA_CLIENTE="Cliente.txt";

   public void crearCliente() {
    util.clearConsole();
    leerA=new LeerArchivo(TABLA_CLIENTE);
    cTo=new ClienteTO();
    System.out.println("*************Crear Cliente****************");
    String dniX=leerT.leer("", "Ingrese un DNI");
    if (noExisteDNI(dniX)) {
        cTo.setDni(dniX);
        cTo.setNombre(leerT.leer("", "Ingrese nombre de cliente"));
        agregarContenido(leerA, cTo);     
    }else{
        System.err.println("El Dni ya esta registrado! intente con otro dni!");
        crearCliente();

    }
   }  
   
   public void crearCliente(String dni) {
    util.clearConsole();
    leerA=new LeerArchivo(TABLA_CLIENTE);
    cTo=new ClienteTO();
    System.out.println("*************Crear Cliente****************");
    //String dniX=leerT.leer("", "Ingrese un DNI");
    if (noExisteDNI(dni)) {
        cTo.setDni(dni);
        cTo.setNombre(leerT.leer("", "Ingrese nombre de cliente"));
        agregarContenido(leerA, cTo);     
    }else{
        System.err.println("El Dni ya esta registrado! intente con otro dni!");
        crearCliente(dni);

    }
   } 
   
   public boolean noExisteDNI(String dni) {
    leerA=new LeerArchivo(TABLA_CLIENTE);
    Object[][] dataC=buscarContenido(leerA, 0, dni);
    if (dataC==null || dataC.length==0) {
        return true;
    }
        return false;
   }

}
