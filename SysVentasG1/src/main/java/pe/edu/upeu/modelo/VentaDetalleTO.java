package pe.edu.upeu.modelo;

import lombok.Data;

@Data
public class VentaDetalleTO {    
 String idDetalle, idVenta, idProducto;
 double cantidad, precioUnit, descuento, total;
} 
