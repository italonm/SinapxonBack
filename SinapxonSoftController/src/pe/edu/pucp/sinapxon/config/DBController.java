/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.config;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Especialidad;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Pais;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.Persona;
import pe.edu.pucp.sinapxon.model.Profesor;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;
import pe.edu.pucp.sinapxon.model.Tema;

/**
 *
 * @author Italo
 */
public abstract class DBController {
    
    private static final DAOFactory daoFactory = DAOFactory.getDAOFactory();
    
    //Catálogo de métodos de acceso
    
    public static Persona validarLogin (String nickname,String password){
        return daoFactory.getPersonaDAO().validar(nickname, password);
    }
    
    public static ArrayList<Classroom> listarClassroomxProfesor(String codigo,String nombre){
        return daoFactory.getClassroomDAO().listarClassroomxProfesor(codigo,nombre);
    }
    
    public static ArrayList<Classroom> listarClassroomxAlumno(String codigo){
        return daoFactory.getClassroomDAO().listarClassroomxAlumno(codigo);
    }
    
    public static ArrayList<Curso> listarCursos(String nombre)
    {
        return daoFactory.getCursoDAO().listarCurso(nombre);
    }
    
    public static ArrayList<Periodo> listarPeriodos(){
        return daoFactory.getPeriodoDAO().listarPeriodo();
    }
    
    public static ArrayList<Periodo> listarPeriodosDisponibles(){
        return daoFactory.getPeriodoDAO().listarPeriodosDisponibles();
    }
    
    public static ArrayList<Periodo> listarRangoPeriodos(Date fechaIni, Date fechaFin){
        return daoFactory.getPeriodoDAO().listarRangoPeriodos(fechaIni, fechaFin);
    }
    
    public static void insertarCurso(Curso curso){
        daoFactory.getCursoDAO().insertarCurso(curso);
    }
    
    public static void insertarAlumno(Alumno alumno){
        daoFactory.getAlumnoDAO().insertarAlumno(alumno);
    }
    
    public static void insertarProfesor(Profesor profesor){
        daoFactory.getProfesorDAO().insertarProfesor(profesor);
    }
   
    public static void insertarIdioma(Idioma idioma){
        daoFactory.getIdiomaDAO().insertarIdioma(idioma);
    }
    
    public static ArrayList<Pais> listarPaises(){
        return daoFactory.getPaisDAO().listarPaises();
    }
    public static ArrayList<Idioma> listarIdiomas(){
        return daoFactory.getIdiomaDAO().listarIdiomas();
    }
    
    public static void insertarSolicitudClassroom(SolicitudClassroom solicitudclassroom){
        daoFactory.getSolicitudClassroomDAO().insertarSolicitudClassroom(solicitudclassroom);
    }
    
    public static void insertarTema(Tema tema){
        daoFactory.getTemaDAO().insertarTema(tema);
    }
    
    public static ArrayList<Profesor> listarProfesores(String nombre){
        return daoFactory.getProfesorDAO().listarProfesores(nombre);
    }
    
    public static void insertarEspecialidad(Especialidad especialidad, String idAdministrador){
        daoFactory.getEspecialidadDAO().insertarEspecialidad(especialidad, idAdministrador);
    }
    
    public static ArrayList<Especialidad> listarEspecialidades(){
        return daoFactory.getEspecialidadDAO().listarEspecialidades();
    }
}
