    package pe.edu.pucp.sinapxon.model;

import java.util.ArrayList;

/**
 *
 * @author Rick
 */
public class Evaluacion {

    /**
     * @return the entregables
     */
//    public ArrayList<Entregable> getEntregables() {
//        return entregables;
//    }
//
//    /**
//     * @param entregables the entregables to set
//     */
//    public void setEntregables(ArrayList<Entregable> entregables) {
//        this.entregables = entregables;
//    }
    
    private int id_evaluacion;
    private String nombre;
    private float peso_porcentual;
    private Classroom classroom;
    //private ArrayList<Entregable> entregables;
    private String descripcion;
    private Tema_x_Classroom tema;
    
    public Evaluacion() {}
    
    public Evaluacion(String nombre) {
        this.nombre = nombre;
        //entregables = new ArrayList<>();
    }
    
    public void agregarEntregable(Entregable entregable){
        //getEntregables().add(entregable);
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

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    public Classroom getClassroom(){
        return classroom;
    }
    
    public void setClassroom(Classroom classroom){
        this.classroom = classroom;
    }
    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tema
     */
    public Tema_x_Classroom getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(Tema_x_Classroom tema) {
        this.tema = tema;
    }
}