package pe.edu.upeu.dao;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.ProductoTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;

public class ProductoDao extends AppCrud{
   LeerTeclado leerT=new LeerTeclado();
   LeerArchivo leerA;
   UtilsX util=new UtilsX();
   
   ProductoTO pTo;
   final static String TABLA_PRODUCTO="Producto.txt";
   final static String TABLA_CATEGORIA="Categoria.txt";
   final static String TABLA_MODELO="Modelo.txt";

   public void crearProducto() {
    
   }

   public void mostrarCategoria() {
        leerA=new LeerArchivo(TABLA_CATEGORIA);
        Object[][] dataC=listarContenido(leerA);
        for (int i = 0; i < dataC.length; i++) {
            System.out.print(dataC[i][0]+"="+dataC[i][1]+", ");
        }
   }

   public void mostrarModelo() {
    leerA=new LeerArchivo(TABLA_MODELO);
    Object[][] dataC=listarContenido(leerA);
    for (int i = 0; i < dataC.length; i++) {
        System.out.print(dataC[i][0]+"="+dataC[i][1]+", ");
    }    
   }

   
}
