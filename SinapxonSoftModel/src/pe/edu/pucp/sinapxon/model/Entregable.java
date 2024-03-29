package pe.edu.pucp.sinapxon.model;


import java.util.*;

/**
 *
 * @author Rick
 */
public class Entregable {
    
    private String descripcion;
    private int nota;
    private Evaluacion evaluacion;
    private Archivo_x_Entregable archivo;
    private ArrayList<Archivo_x_Entregable> archivos;
    private Classroom_x_Alumno alumno;
    
    public Entregable() {}
    
    public Archivo_x_Entregable getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo_x_Entregable archivo) {
        this.archivo = archivo;
    }
    
    public Entregable(String descripcion, int nota, Evaluacion evaluacion, Classroom_x_Alumno alumno) {
        this.descripcion = descripcion;
        this.nota = nota;
        this.evaluacion = evaluacion;
        this.archivos = new ArrayList<>();
        this.alumno = alumno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void setArchivos(Archivo_x_Entregable archivos) {
        this.archivos.add(archivos);
    }

    public Classroom_x_Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Classroom_x_Alumno alumno) {
        this.alumno = alumno;
    }
}