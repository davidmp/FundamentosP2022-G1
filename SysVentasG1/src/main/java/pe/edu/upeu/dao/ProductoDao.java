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
    leerA=new LeerArchivo(TABLA_PRODUCTO);
    pTo=new ProductoTO();
    String idPro=generarId(leerA, 0, "P", 1);
    pTo.setIdProducto(idPro);
    pTo.setNombreProd(leerT.leer("", "Nombre Producto"));
    mostrarCategoria();
    pTo.setIdCat(leerT.leer("", "Seleccione una Categoria"));
    mostrarModelo();
    pTo.setIdMod(leerT.leer("", "Seleccione un modelo"));
    pTo.setPrecioUnid(leerT.leer(0.0, "ingrese el Precio Unitario"));
    pTo.setUtilidad(leerT.leer(0.0, "Ingrese la utilidad"));
    pTo.setUnidMed(leerT.leer("", "Unidad Medida"));
    pTo.setStock(leerT.leer(0, "Ingrese Cantidad"));
    pTo.setCantMayor(leerT.leer(0, "Ingrese cantidad para descuento"));
    leerA=new LeerArchivo(TABLA_PRODUCTO);
    agregarContenido(leerA, pTo);
   }

   public void mostrarCategoria() {
        leerA=new LeerArchivo(TABLA_CATEGORIA);
        Object[][] dataC=listarContenido(leerA);
        for (int i = 0; i < dataC.length; i++) {
            System.out.print(dataC[i][0]+"="+dataC[i][1]+", ");
        }
        System.out.println("");
   }

   public void mostrarModelo() {
    leerA=new LeerArchivo(TABLA_MODELO);
    Object[][] dataC=listarContenido(leerA);
    for (int i = 0; i < dataC.length; i++) {
        System.out.print(dataC[i][0]+"="+dataC[i][1]+", ");
    }   
    System.out.println(""); 
   }

   
}
