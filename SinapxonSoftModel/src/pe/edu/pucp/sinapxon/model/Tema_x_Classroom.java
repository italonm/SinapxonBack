/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.model;

import java.util.ArrayList;

/**
 *
 * @author Italo
 */
public class Tema_x_Classroom {
    private int id_tema;
    private String nombre;
    private String descripcion;
    private Tema tema;
    private ArrayList<Archivo_x_Tema> archivoxTema;
    private Evaluacion evaluacion;

    public Tema_x_Classroom(int id_tema, String nombre, String descripcion, Tema tema, Evaluacion evaluacion) {
        this.id_tema = id_tema;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tema = tema;
        this.evaluacion = evaluacion;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
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

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public void setArchivoxTema(Archivo_x_Tema archivoxTema) {
        this.archivoxTema.add(archivoxTema);
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }
    
    
}
