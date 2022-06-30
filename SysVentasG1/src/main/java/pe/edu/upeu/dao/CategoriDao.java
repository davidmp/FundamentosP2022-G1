package pe.edu.upeu.dao;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.CategoriaTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;

public class CategoriDao extends AppCrud {
    LeerTeclado leerT=new LeerTeclado();
    LeerArchivo leerA; 
    UtilsX util=new UtilsX();
    CategoriaTO cTo;
    final static String TABLA_CATEGORIA="Categoria.txt";

   public void crearCategoria() {
    leerA=new LeerArchivo(TABLA_CATEGORIA);
    cTo=new CategoriaTO();
    System.out.println("*************Crear Categoria****************");
    leerA=new LeerArchivo(TABLA_CATEGORIA);
    String idCat=generarId(leerA, 0, "C", 1);
    cTo.setIdCat(idCat);
    cTo.setNombreCat(leerT.leer("", "Ingrese nombre categoria"));
    agregarContenido(leerA, cTo);
   }    
}
