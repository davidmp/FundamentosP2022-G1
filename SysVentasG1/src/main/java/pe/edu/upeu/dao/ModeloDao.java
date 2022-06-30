package pe.edu.upeu.dao;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.ModeloTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;

public class ModeloDao extends AppCrud{
    LeerTeclado leerT=new LeerTeclado();
    LeerArchivo leerA; 
    UtilsX util=new UtilsX();
    ModeloTO mTo;
    final static String TABLA_MODELO="Modelo.txt";

   public void crearModelo() {
    leerA=new LeerArchivo(TABLA_MODELO);
    mTo=new ModeloTO();
    System.out.println("*************Crear Modelo****************");
    leerA=new LeerArchivo(TABLA_MODELO);
    String idMod=generarId(leerA, 0, "M", 1);
    mTo.setIdModelo(idMod);
    mTo.setNombreModelo(leerT.leer("", "Ingrese nombre Modelo"));
    agregarContenido(leerA, mTo);
   }    
}
