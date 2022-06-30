package pe.edu.upeu.dao;

import java.io.Console;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.UsuarioTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;

public class UsuarioDao extends AppCrud{
    LeerTeclado leerT=new LeerTeclado();
    LeerArchivo leerA; 
    UtilsX util=new UtilsX();
    UsuarioTO uTo;
    final static String TABLA_USUARIO="Usuario.txt";

   public void crearUsuario() {
    leerA=new LeerArchivo(TABLA_USUARIO);
    uTo=new UsuarioTO();
    System.out.println("*************Crear Usuario****************");
    uTo.setUsuario(leerT.leer("", "Ingrese un Usuario:"));
    Console cons=System.console();
    System.out.println("Ingrese su clave:");
    char[] claveX=cons.readPassword();
    uTo.setClave(String.valueOf(claveX));
    agregarContenido(leerA, uTo);
   }

   public boolean loginValidar(String usuario, String clave) {
        leerA=new LeerArchivo(TABLA_USUARIO);
        Object[][] dataU=buscarContenido(leerA, 0, usuario);
        if(dataU.length==1 && String.valueOf(dataU[0][1]).equals(clave)){
            return true;
        }
        return false;
   }
   


}
