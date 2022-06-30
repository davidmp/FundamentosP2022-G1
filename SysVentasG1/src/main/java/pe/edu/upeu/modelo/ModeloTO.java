package pe.edu.upeu.modelo;

/**
 * ModeloTO
 */
public class ModeloTO {
    public String idModelo;
    public String nombreModelo;
    
    public ModeloTO(){
        
    }

    public ModeloTO(String idModelo, String nombreModelo) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
    }

    public String getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(String idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }


    
    
}