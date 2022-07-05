package pe.edu.upeu.modelo;

import lombok.Data;

@Data
public class VentaTO {    
   public String idVenta, dni;
   public double descuento,subprecio, igv, precioTotal;
}
