package pe.edu.pucp.sinapxon.model;


import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Rick
 */
public class Classroom implements Serializable {
    
    private int id_classroom;
    private String codigo;
    private Curso curso;
    private Profesor profesor;
    private ArrayList<Classroom_x_Alumno> alumnos;
    private ArrayList<Tema_x_Classroom> temas;
    private int activo;
    private Periodo periodo;
    private Idioma idioma;
    
    public Classroom() {}
    
    public Classroom(Curso curso) {
        this.activo=1;
        this.curso=curso;
        alumnos = new ArrayList<>();
        temas = new ArrayList<>();
        this.profesor = new Profesor();
    }

    public ArrayList<Classroom_x_Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Classroom_x_Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public ArrayList<Tema_x_Classroom> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<Tema_x_Classroom> temas) {
        this.temas = temas;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
    
    public int getId_classroom() {
        return id_classroom;
    }
    
    public void setId_classroom(int id_classroom) {
        this.id_classroom = id_classroom;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Curso getCurso() {
        return curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public Profesor getProfesor() {
        return profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public int getActivo() {
        return activo;
    }
    
    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    public void agregarTema(Tema_x_Classroom tema){
        temas.add(tema);
    }
    
    public void agregarAlumno(Classroom_x_Alumno alumno){
        alumnos.add(alumno);
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    
    public void setIdiomaid(int id){
        this.idioma.setId_idioma(id);
    }
    
    public int getIdiomaid(){
        return this.idioma.getId_idioma();
    }
}