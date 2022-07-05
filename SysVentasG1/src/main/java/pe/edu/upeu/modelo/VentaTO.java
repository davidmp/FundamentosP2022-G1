package pe.edu.upeu.modelo;

import lombok.Data;

@Data
public class VentaTO {    
    String idVenta, dni;
    double descuento,subprecio, igv, precioTotal;
}
