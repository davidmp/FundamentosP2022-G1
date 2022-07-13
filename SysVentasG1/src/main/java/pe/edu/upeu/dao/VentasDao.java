package pe.edu.upeu.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.ProductoTO;
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

    public SimpleDateFormat formatFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public SimpleDateFormat formatFecha = new SimpleDateFormat("dd-MM-yyyy");

    VentaTO vTo;
    VentaDetalleTO vdTo;

    public void registroVentaGeneral() {
        util.clearConsole();
        System.out.println("**************Realizar Venta*************");
        String dnix=leerT.leer("", "Ingrese DNI del cliente");
        VentaTO vTo=new VentaTO();
        vTo.setDni(validarCliente(dnix)); 
        leerA=new LeerArchivo(TABLA_VENTA);
        String idV=generarId(leerA, 0, "V", 1);              
        vTo.setIdVenta(idV);
        vTo.setFecha(formatFechaHora.format(new Date()));

        leerA=new LeerArchivo(TABLA_VENTA); 
        agregarContenido(leerA, vTo);
        leerA=new LeerArchivo(TABLA_VENTA);
        Object[][] dataV=buscarContenido(leerA, 0, idV);
        if (dataV.length==1) {
            carritoVenta(vTo);
        }            
    }



    public void carritoVenta(VentaTO vtox) {
        char continuar=' ';
        double preciototalX=0;
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
            Object[][] dataPX=buscarContenido(leerA,0, vdTo.getIdProducto());
            vdTo.setPrecioUnit(Double.parseDouble(String.valueOf(dataPX[0][5]))+
            Double.parseDouble(String.valueOf(dataPX[0][6])));
            vdTo.setTotal(vdTo.getCantidad()*vdTo.getPrecioUnit());
            preciototalX+=vdTo.getTotal();
            leerA=new LeerArchivo(TABLA_DETALLEVENTA);
            agregarContenido(leerA, vdTo);
            
            descontarStockProducto(vdTo);
            
            continuar=leerT.leer("", "Desea Agregar mas Productos?S/N")
            .toLowerCase()
            .charAt(0);
        } while (continuar=='s');
        vtox.setSubprecio(Math.round((preciototalX/1.18)*100.0)/100.0);
        vtox.setIgv(Math.round((vtox.getSubprecio()*0.18)*100.0)/100.0);
        vtox.setPrecioTotal(Math.round(preciototalX*100.0)/100.0);
        leerA=new LeerArchivo(TABLA_VENTA);
        editarRegistro(leerA, 0, vtox.getIdVenta(), vtox);
    }

    public void descontarStockProducto(VentaDetalleTO vdTX) {
        leerA=new LeerArchivo(TABLA_PRODUCTO); 
        Object[][] dataP=buscarContenido(leerA, 0, vdTX.getIdProducto());
        ProductoTO to=new ProductoTO();
        to.setStock(Double.parseDouble(String.valueOf(dataP[0][7]))-vdTX.getCantidad());
        leerA=new LeerArchivo(TABLA_PRODUCTO); 
        editarRegistro(leerA, 0, vdTX.getIdProducto(), to);
    }

    public void mostrarProductos() {
        util.clearConsole();
        System.out.println("*******************Lista de Productos*************");
        leerA=new LeerArchivo(TABLA_PRODUCTO);
        Object[][] dataP=listarContenido(leerA);
        for (int i = 0; i < dataP.length; i++) {
            if(Double.parseDouble(String.valueOf(dataP[i][7]))>0){
                System.out.print(dataP[i][0]+"="+dataP[i][1]+"("+dataP[i][7]+")"+",");
            }
        }
        System.out.println("");
    }


    public String validarCliente(String dni) {
        leerA=new LeerArchivo(TABLA_CLIENTE);
        Object[][] dataC=buscarContenido(leerA, 0, dni);
        if (dataC==null || dataC.length==0) {
            new ClienteDao().crearCliente(dni);           
        }        
        return dni;
    }

    public void reporteVentas() {
        util.clearConsole();
        System.out.println("******************Reporte de Ventas por Fechas*****************");
        leerA=new LeerArchivo(TABLA_VENTA);
        Object[][] dataP=listarContenido(leerA);
        String fechaI=leerT.leer("", "Ingrese Fecha Inicio (dd-MM-YYYY)");
        String fechaF=leerT.leer("", "Ingrese Fecha Fin (dd-MM-YYYY)");
        int cantidadFilas=0;
        try {
            for (int i = 0; i < dataP.length; i++) {
                String[] fechaSeparada=String.valueOf(dataP[i][2]).split(" ");
                Date fechaV=formatFecha.parse(fechaSeparada[0]);
                if (
                    (fechaV.after(formatFecha.parse(fechaI)) || fechaSeparada[0].equals(fechaI)) &&
                    (fechaV.before(formatFecha.parse(fechaF)) || fechaSeparada[0].equals(fechaF))                
                    ) {
                        cantidadFilas++;
                }
            }
            VentaTO[] ventasERF=new VentaTO[cantidadFilas];
            int indiceVector=0;
            for (int i = 0; i < dataP.length; i++) {
                String[] fechaSeparada=String.valueOf(dataP[i][2]).split(" ");
                Date fechaV=formatFecha.parse(fechaSeparada[0]);
                if (
                    (fechaV.after(formatFecha.parse(fechaI)) || fechaSeparada[0].equals(fechaI)) &&
                    (fechaV.before(formatFecha.parse(fechaF)) || fechaSeparada[0].equals(fechaF))                
                    ) {
                        VentaTO vTX=new VentaTO();
                        vTX.setIdVenta(String.valueOf(dataP[i][0]));
                        vTX.setDni(String.valueOf(dataP[i][1]));
                        vTX.setFecha(String.valueOf(dataP[i][2]));
                        vTX.setDescuento(Double.parseDouble(String.valueOf(dataP[i][3])));
                        vTX.setSubprecio(Double.parseDouble(String.valueOf(dataP[i][4])));
                        vTX.setIgv(Double.parseDouble(String.valueOf(dataP[i][5])));
                        vTX.setPrecioTotal(Double.parseDouble(String.valueOf(dataP[i][6])));
                        ventasERF[indiceVector]=vTX;
                        indiceVector++;
                }
            }            
            System.out.printf("%s %s %5s %15s %3s %3s %3s %4s %n","#", "IdV", "DNI", 
            "Fecha","Desct.", "P.Base", "IGV", "P.Total");
            int num=0;

            //System.out.println(ventasERF.length);
            for (VentaTO ventaTO : ventasERF) {
                System.out.printf("%d %s %5s %15s %3.2f %3.2f %3.2f %4.2f %n",
                (++num), ventaTO.getIdVenta(),ventaTO.getDni(),
                ventaTO.getFecha(),ventaTO.getDescuento(),ventaTO.getSubprecio(),
                ventaTO.getIgv(),ventaTO.getPrecioTotal()
                );
            }

        } catch (Exception e) {
           System.err.println("Error al reportar!!");
        }
    }

    public void reporteVentasRangoFecha() {
        util.clearConsole();
        System.out.println("===================Reporte de Ventas==================");
        String fechaInit=leerT.leer("", "Ingrese F. Inicio (dd-MM-yyyy)");
        String fechaFinal=leerT.leer("", "Ingrese F. Final (dd-MM-yyyy)");
        leerA=new LeerArchivo(TABLA_VENTA);
        Object[][] dataV=listarContenido(leerA);
        int contadorVRD=0;
        try {
            //Para saber que cantidad de registros coinciden con el rango de fecha
            for (int i = 0; i < dataV.length; i++) {
                String[] fechaVentor=String.valueOf(dataV[i][2]).split(" ");
                Date fechaVentaX=formatFecha.parse(fechaVentor[0]);
                if(
                (fechaVentaX.after(formatFecha.parse(fechaInit)) || fechaInit.equals(fechaVentor[0])) && 
                (fechaVentaX.before(formatFecha.parse(fechaFinal)) || fechaFinal.equals(fechaVentor[0]))
                ){
                    contadorVRD++; 
                }
            }

            //Pasar los datos a un Vetor de tipo VentaTO segun Rango Fechas
            VentaTO[] dataReal=new VentaTO[contadorVRD];
            int indiceVector=0;
            for (int i = 0; i < dataV.length; i++) {
                String[] fechaVentor=String.valueOf(dataV[i][2]).split(" ");
                Date fechaVentaX=formatFecha.parse(fechaVentor[0]);
                if(
                (fechaVentaX.after(formatFecha.parse(fechaInit)) || fechaInit.equals(fechaVentor[0])) && 
                (fechaVentaX.before(formatFecha.parse(fechaFinal)) || fechaFinal.equals(fechaVentor[0]))
                ){
                   VentaTO vTo=new VentaTO();
                   vTo.setIdVenta(dataV[i][0].toString());
                   vTo.setDni(dataV[i][1].toString());
                   vTo.setFecha(dataV[i][2].toString());

                   vTo.setDescuento(Double.parseDouble(String.valueOf(dataV[i][3].toString())));
                   vTo.setSubprecio(Double.parseDouble(String.valueOf(dataV[i][4])));
                   vTo.setIgv(Double.parseDouble(String.valueOf(dataV[i][5])));
                   vTo.setPrecioTotal(Double.parseDouble(String.valueOf(dataV[i][6])));
                   
                   dataReal[indiceVector]=vTo;
                   indiceVector++;
                }
            }
            //Imprimir Ventas     
            Ansi color;
            AnsiConsole.systemInstall();
            color=new Ansi();
            System.out.println(color.bgBrightYellow().fgBlack()
            .a("===========Reporte Ventas entre "+fechaInit+" Y "+fechaFinal+"============").reset());
            
            util.pintarLine('H', 40);
            util.pintarTextHeadBody('H', 3, "ID,DNI,Fecha, Descuento,Sub. Total, IGV, Imp.Total");
            System.out.println("");
            double subtotalX=0,igvX=0, importeTX =0;
            util.pintarLine('H', 40);
            for (VentaTO TOv : dataReal) {
                String datax=TOv.getIdVenta()+","+TOv.getDni()+","+TOv.getFecha()+","+
                TOv.getDescuento()+","+TOv.getSubprecio()+","+TOv.getIgv()+","+TOv.getPrecioTotal();

                subtotalX+=TOv.getSubprecio(); 
                igvX+=TOv.getIgv(); 
                importeTX+=TOv.getPrecioTotal();
                util.pintarTextHeadBody('B', 3, datax);
            }
            //System.out.println("");
            color=new Ansi();
            util.pintarLine('H', 40);            
            System.out.println(color.render(
            
            "| @|red Sub. Total:|@ | @|blue S/"+ subtotalX+" |@ | @|red IGV: |@ @|blue S/."+igvX+
            "|@ | @|red Imp. Total: |@ @|blue S/."+importeTX+"|@"
            
            )
            );
            util.pintarLine('H', 40);            


        } catch (Exception e) {
           System.err.println("Error al Reportar!!"+e.getMessage());
        }
    }    


}
