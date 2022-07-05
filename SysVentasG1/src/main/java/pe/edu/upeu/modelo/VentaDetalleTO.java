package pe.edu.upeu.modelo;

import lombok.Data;

@Data
public class VentaDetalleTO {    
    public String idDetalle, idVenta, idProducto;
    public double cantidad, precioUnit, descuento, total;
} 
