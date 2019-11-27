package pe.edu.pucp.sinapxon.model;


import java.util.*;

/**
 * 
 */
public class Archivo_x_Tema {
    
    private int id_archivo_x_tema;
    private String nombre;
    private Tema_x_Classroom tema;
    private String descripcion;
    
    public Archivo_x_Tema() {
        
    }

    public Archivo_x_Tema(int id_archivo_x_tema, String nombre) {
        this.id_archivo_x_tema = id_archivo_x_tema;
        this.nombre = nombre;
    }

    public int getId_archivo_x_tema() {
        return id_archivo_x_tema;
    }
    
    public void setId_archivo_x_tema(int id_archivo_x_tema) {
        this.id_archivo_x_tema = id_archivo_x_tema;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setTema(Tema_x_Classroom tema) {
        this.tema = tema;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}