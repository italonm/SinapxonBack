package pe.edu.pucp.sinapxon.model;


import java.util.*;

/**
 * 
 */
public class Tema {
    
    private int id_tema;
    private String nombre;
    private String descripcion;
    private String link;
    private Classroom classroom;
    
    public Tema() {
        
    }
    
    public Tema(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the id_tema
     */
    public int getId_tema() {
        return id_tema;
    }

    /**
     * @param id_tema the id_tema to set
     */
    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the classroom
     */
    public Classroom getClassroom() {
        return classroom;
    }

    /**
     * @param classroom the classroom to set
     */
    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
    
    
}