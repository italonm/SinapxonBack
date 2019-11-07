package pe.edu.pucp.sinapxon.model;


import java.util.*;

/**
 * 
 */
public class Evaluacion {
    
    private int id_evaluacion;
    private String nombre;
    private float peso_porcentual;
    private ArrayList<Entregable> entregables;
    
    public Evaluacion() {
        
    }
    
    public Evaluacion(String nombre) {
        this.nombre = nombre;
        entregables = new ArrayList<Entregable>();
    }
    
    public void agregarEntregable(Entregable entregable){
        entregables.add(entregable);
    }

    public int getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(int id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso_porcentual() {
        return peso_porcentual;
    }

    public void setPeso_porcentual(float peso_porcentual) {
        this.peso_porcentual = peso_porcentual;
    }
}