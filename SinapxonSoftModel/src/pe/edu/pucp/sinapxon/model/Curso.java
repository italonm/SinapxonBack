package pe.edu.pucp.sinapxon.model;


import java.util.*;

/**
 * 
 */
public class Curso {
    
    private int id_curso;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Especialidad especialidad;
    private ArrayList<Classroom> classrooms;
    private ArrayList<Curso> cursos;
    private Administrador administrador;
    private int estado;
    
    
    public Curso() {
        
    }
    
    public Curso(String nombre, String descripcion) {
        this.nombre=nombre;
        this.descripcion=descripcion;
        classrooms = new ArrayList<Classroom>();
        cursos = new ArrayList<Curso>();
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
    
    public void agregarClassroom(Classroom classroom){
        classrooms.add(classroom);
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    public int getEstado() {
        return estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
}