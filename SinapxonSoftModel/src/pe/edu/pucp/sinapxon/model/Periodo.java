/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Italo
 */
public class Periodo {
    private int id_periodo;
    private String nombre;
    private Administrador administrador;
    private Date fecha_inicio;
    private Date fecha_fin;
    private ArrayList<Classroom> classrooms;

    public Periodo(){
        this.classrooms = new ArrayList<>();
    }
    
    public Periodo(int id_periodo, Date fecha_inicio, Date fecha_fin) {
        this.id_periodo = id_periodo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setClassrooms(Classroom classrooms) {
        this.classrooms.add(classrooms);
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
