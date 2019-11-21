package pe.edu.pucp.sinapxon.model;

/**
 *
 * @author Rick
 */
public class Archivo_x_Entregable {
    
    private int id_archivo_x_entregable;
    private String nombre;
    private Entregable entregable;
    
    public Archivo_x_Entregable(String nombre) {
        this.nombre = nombre;
    }
    
    public Archivo_x_Entregable() {}
    
    public int getId_archivo_x_entregable() {
        return id_archivo_x_entregable;
    }
    
    public void setId_archivo_x_entregable(int id_archivo_x_entregable) {
        this.id_archivo_x_entregable = id_archivo_x_entregable;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Entregable getEntregable() {
        return entregable;
    }
    
    public void setEntregable(Entregable entregable) {
        this.entregable = entregable;
    }
}