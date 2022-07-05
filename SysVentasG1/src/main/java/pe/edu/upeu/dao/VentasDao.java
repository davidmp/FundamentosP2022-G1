package pe.edu.upeu.dao;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.VentaDetalleTO;
import pe.edu.upeu.modelo.VentaTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;

public class VentasDao extends AppCrud{
    LeerTeclado leerT=new LeerTeclado();
    LeerArchivo leerA; 
    UtilsX util=new UtilsX();
    
    final static String TABLA_VENTA="Venta.txt";
    final static String TABLA_PRODUCTO="Producto.txt";
    final static String TABLA_DETALLEVENTA="DetalleVenta.txt";
    final static String TABLA_CLIENTE="Cliente.txt";

    VentaTO vTo;
    VentaDetalleTO vdTo;

    public void registroVentaGeneral() {
        util.clearConsole();
        System.out.println("**************Realizar Venta*************");
        String dnix=leerT.leer("", "Ingrese DNI del cliente");
        if (validarCliente(dnix)) {
            vTo=new VentaTO();
            vTo.setDni(dnix);
            vTo.setDescuento(0);
            leerA=new LeerArchivo(TABLA_VENTA);
            String idV=generarId(leerA, 0, "V", 1);
            vTo.setIdVenta(idV);
        }
    }

    public void venta(VentaTO vtox) {
        leerA=new LeerArchivo(TABLA_VENTA);
        agregarContenido(leerA, vtox);
    }

    public void carritoVenta(VentaTO vtox) {
        char continuar=' ';
        do {
            mostrarProductos();
            //agregar productos
            vdTo=new VentaDetalleTO();
            leerA=new LeerArchivo(TABLA_DETALLEVENTA);
            String idvX=generarId(leerA, 0, "DV", 2);
            vdTo.setIdDetalle(idvX);
            vdTo.setIdProducto(leerT.leer("", "Ingrese Id Producto"));
            vdTo.setCantidad(leerT.leer(0, "Ingrese Cantidad"));
            vdTo.setIdVenta(vtox.getIdVenta());
            vdTo.setDescuento(0);
            leerA=new LeerArchivo(TABLA_PRODUCTO);
            Object[][] dataPX=buscarContenido(leerA,5, vdTo.getIdProducto());
            vdTo.setPrecioUnit(Double.parseDouble(String.valueOf(dataPX[0][5])));
            vdTo.setTotal(vdTo.getCantidad()*vdTo.getPrecioUnit());
            leerA=new LeerArchivo(TABLA_DETALLEVENTA);
            agregarContenido(leerA, vdTo);
            
            continuar=leerT.leer("", "Desea Agregar mas Productos?S/N")
            .toLowerCase()
            .charAt(0);
        } while (continuar=='s');
    }

    public void mostrarProductos() {
        leerA=new LeerArchivo(TABLA_PRODUCTO);
        Object[][] dataP=listarContenido(leerA);
        for (int i = 0; i < dataP.length; i++) {
            System.out.print(dataP[i][0]+"="+dataP[i][1]+",");
        }
        System.out.println("");
    }


    public boolean validarCliente(String dni) {
        leerA=new LeerArchivo(TABLA_CLIENTE);
        Object[][] dataC=buscarContenido(leerA, 0, dni);
        if (dataC==null || dataC.length==0) {
            new ClienteDao().crearCliente(dni);
            return true;
        }else{
            return true;
        }        
    }




}
