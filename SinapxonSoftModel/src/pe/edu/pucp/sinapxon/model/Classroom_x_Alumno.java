/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.model;

import java.util.ArrayList;

/**
 *
 * @author Rick
 */
public class Classroom_x_Alumno {
    private int id_Classroom_x_Alumno;
    private Alumno alumno;
    private Classroom classroom;
    private int vez;
    private float nota_final;
    private int etapaActual;
    private ArrayList<Entregable> entregables;

    public Classroom_x_Alumno(){}
    
    public Classroom_x_Alumno(int id_Classroom_x_Alumno, Alumno alumno, Classroom classroom, int vez, float nota_final, int etapaActual) {
        this.id_Classroom_x_Alumno = id_Classroom_x_Alumno;
        this.alumno = alumno;
        this.classroom = classroom;
        this.vez = vez;
        this.nota_final = nota_final;
        this.etapaActual = etapaActual;
    }
    
    public int getId_Classroom_x_Alumno() {
        return id_Classroom_x_Alumno;
    }

    public void setId_Classroom_x_Alumno(int id_Classroom_x_Alumno) {
        this.id_Classroom_x_Alumno = id_Classroom_x_Alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public int getVez() {
        return vez;
    }

    public void setVez(int vez) {
        this.vez = vez;
    }

    public float getNota_final() {
        return nota_final;
    }

    public void setNota_final(float nota_final) {
        this.nota_final = nota_final;
    }

    public int getEtapaActual() {
        return etapaActual;
    }

    public void setEtapaActual(int etapaActual) {
        this.etapaActual = etapaActual;
    }

    public void setEntregables(Entregable entregable) {
        this.entregables.add(entregable);
    }
}
