package pe.edu.upeu.util;

import java.net.URL;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class UtilsX {
    public int fibonaciRecur(final int numero) {
        if (numero < 2) {
            return numero;
        } else {
            return fibonaciRecur(numero - 1) + fibonaciRecur(numero - 2);
        }
    }

    public URL getFile(String ruta) {
        return this.getClass().getResource("/" + ruta);
    }

    public TableModel reporData() {
        return null;
    }
}
