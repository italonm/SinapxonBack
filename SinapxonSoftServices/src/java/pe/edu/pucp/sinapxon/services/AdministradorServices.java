/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.services;

import java.time.Period;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.sinapxon.config.DBController;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Pais;
import pe.edu.pucp.sinapxon.model.Especialidad;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.Profesor;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;

/**
 *
 * @author Italo
 */
@WebService(serviceName = "AdministradorServices")
public class AdministradorServices {

    //Curso
    //==========================================================================
    @WebMethod(operationName = "insertarCurso")
    public void insertarCurso(Curso curso){
        DBController.insertarCurso(curso);
    }
    
    @WebMethod(operationName = "actualizarCurso")
    public int actualizarCurso(Curso curso){
        return DBController.actualizarCurso(curso);
    }
    
    @WebMethod(operationName = "eliminaCurso")
    public int eliminarCurso(String idCurso){
        return DBController.eliminarCurso(idCurso);
    }
    
    @WebMethod(operationName = "listarCursos")
    public ArrayList<Curso> listarCursos(String nombre) {
        ArrayList<Curso> cursos = DBController.listarCursos(nombre);
        return cursos;
    }
    
    @WebMethod(operationName = "listarRequisitos")
    public ArrayList<Curso> listarRequisitos(String codCur) {
        ArrayList<Curso> requisitos = DBController.listarRequisitos(codCur);
        return requisitos;
    }
    
    @WebMethod(operationName = "listarCursosSin")
    public ArrayList<Curso> listarCursosSin(String nombre) {
        ArrayList<Curso> cursos = DBController.listarCursosSin(nombre);
        return cursos;
    }
    
    //Especialidad 
    //==========================================================================
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
    
    @WebMethod(operationName = "listarEspecialidades")
    public ArrayList<Especialidad> listarEspecialidades(String nombre) {
        ArrayList<Especialidad> especialidades = DBController.listarEspecialidades(nombre);
        return especialidades;
    }
    
    //Alumno
    //==========================================================================
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
    
    @WebMethod(operationName = "listarAlumnos")
    public ArrayList<Alumno> listarAlumnos(String nombre) {
        ArrayList<Alumno> alumnos = DBController.listarAlumnos(nombre);
        return alumnos;
    }
    
    //Profesor
    //==========================================================================
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
    
    @WebMethod(operationName = "listarProfesores")
    public ArrayList<Profesor> listarProfes(String nombre) {
        ArrayList<Profesor> profesores = DBController.listarProfesores(nombre);
        return profesores;
    }
    
    //Pais
    //==========================================================================
    @WebMethod(operationName = "listarPaises")
    public ArrayList<Pais> listarPaises() {
        ArrayList<Pais> paises = DBController.listarPaises();
        return paises;
    }
    
    //Solicitud
    //==========================================================================
    @WebMethod(operationName = "listarSolicitudes")
    public ArrayList<SolicitudClassroom> listarSolicitudesClassroom(int tipo){
        ArrayList<SolicitudClassroom> solicitudes = DBController.listarSolicitudesClassroom(tipo);
        return solicitudes;
    }
    
    @WebMethod(operationName = "listarIdiomasXNombreCodigo")
    public ArrayList<Idioma> listarIdiomasXNombreCodigo(String nombreCodigo){
        ArrayList<Idioma> idiomas = DBController.listarIdiomasXNombre_codigo(nombreCodigo);
        return idiomas;
    }
    
    @WebMethod(operationName = "obtenerPeriodo")
    public Periodo obtenerPeriodo(int codigo){
        Periodo periodo = DBController.obtenrPeriodo_X_codigo(codigo);
        return periodo;
    }
    
    @WebMethod(operationName = "cambiarEstadoSolicitud")
    public void cambiarEstadoSolicitud(int idSolicitud, int estadoSolicitud){
        DBController.aceptarRechazarSolicitudClassroom(idSolicitud, estadoSolicitud);
    }
    
    @WebMethod(operationName = "crearClassroom_y_asignarProfesor")
    public void crearClassroom_y_asignarProfesor(SolicitudClassroom solicitudClassroom){
        DBController.crearClassroomYasignarProfesor(solicitudClassroom);
    }
}
