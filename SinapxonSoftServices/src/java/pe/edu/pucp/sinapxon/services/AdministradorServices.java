/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.sinapxon.config.DBController;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Especialidad;
import pe.edu.pucp.sinapxon.model.Pais;
import pe.edu.pucp.sinapxon.model.Profesor;

/**
 *
 * @author Italo
 */
@WebService(serviceName = "AdministradorServices")
public class AdministradorServices {

    @WebMethod(operationName = "insertarCurso")
    public int insertarCurso(Curso curso){
        return DBController.insertarCurso(curso);
    }
    
    @WebMethod(operationName = "actualizarCurso")
    public int actualizarCurso(Curso curso){
        return DBController.actualizarCurso(curso);
    }
    
    @WebMethod(operationName = "eliminaCurso")
    public int eliminarCurso(String idCurso){
        return DBController.eliminarCurso(idCurso);
    }
    
    @WebMethod(operationName = "insertarProfesor")
    public int insertarProfesor(Profesor profesor){
        return DBController.insertarProfesor(profesor);
    }
    
    @WebMethod(operationName = "actualizarProfesor")
    public int actualizarProfesor(Profesor profesor){
        return DBController.actualizarProfesor(profesor);
    }
    
    @WebMethod(operationName = "eliminarProfesor")
    public int eliminarProfesor(String idProfesor){
        return DBController.eliminarProfesor(idProfesor);
    }
    
    @WebMethod(operationName = "insertarAlumno")
    public int insertarAlumno(Alumno alumno){
        return DBController.insertarAlumno(alumno);
    }

    @WebMethod(operationName = "actualizarAlumno")
    public int actualizarAlumno(Alumno alumno){
        return DBController.actualizarAlumno(alumno);
    }
    
    @WebMethod(operationName = "eliminarAlumno")
    public int eliminarAlumno(String idAlumno){
        return DBController.eliminarAlumno(idAlumno);
    }
    
    @WebMethod(operationName = "insertarEspecialidad")
    public int insertarEspecialidad(Especialidad especialidad){
        return DBController.insertarEspecialidad(especialidad);
    }

    @WebMethod(operationName = "actualizarEspecialidad")
    public int actualizarEspecialidad(Especialidad especialidad){
        return DBController.actualizarEspecialidad(especialidad);
    }
    
    @WebMethod(operationName = "eliminarEspecialidad")
    public int eliminarEspecialidad(int idEspecialidad){
        return DBController.eliminarEspecialidad(idEspecialidad);
    }
    
    @WebMethod(operationName = "listarCursos")
    public ArrayList<Curso> listarCursos(String nombre) {
        ArrayList<Curso> cursos = DBController.listarCursos(nombre);
        return cursos;
    }
    
    @WebMethod(operationName = "listarProfesores")
    public ArrayList<Profesor> listarProfes(String nombre) {
        ArrayList<Profesor> profesores = DBController.listarProfesores(nombre);
        return profesores;
    }
    
    @WebMethod(operationName = "listarAlumnos")
    public ArrayList<Alumno> listarAlumnos(String nombre) {
        ArrayList<Alumno> alumnos = DBController.listarAlumnos(nombre);
        return alumnos;
    }
    
    @WebMethod(operationName = "listarPaises")
    public ArrayList<Pais> listarPaises() {
        ArrayList<Pais> paises = DBController.listarPaises();
        return paises;
    }
    
    @WebMethod(operationName = "listarEspecialidades")
    public ArrayList<Especialidad> listarEspecialidades(String nombre) {
        ArrayList<Especialidad> especialidades = DBController.listarEspecialidades(nombre);
        return especialidades;
    }
}
