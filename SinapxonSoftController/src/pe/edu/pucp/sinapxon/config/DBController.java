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
import pe.edu.pucp.sinapxon.model.Evaluacion;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Pais;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.Persona;
import pe.edu.pucp.sinapxon.model.Profesor;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;
import pe.edu.pucp.sinapxon.model.Tema;
import pe.edu.pucp.sinapxon.model.Tema_x_Classroom;

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
    
    public static Persona validarCorreo (String correo){
        return daoFactory.getPersonaDAO().validarCorreo(correo);
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
    
    public static int insertarAlumno(Alumno alumno){
        return daoFactory.getAlumnoDAO().insertarAlumno(alumno);
    public static int actualizarCurso(Curso curso){
        return daoFactory.getCursoDAO().actualizarCurso(curso);
    }
    
    public static int actualizarAlumno(Alumno alumno){
        return daoFactory.getAlumnoDAO().actualizarAlumno(alumno);
    public static int eliminarCurso(String idCurso){
        return daoFactory.getCursoDAO().eliminarCurso(idCurso);
    }
    
    public static int eliminarAlumno(String idAlumno){
        return daoFactory.getAlumnoDAO().eliminarAlumno(idAlumno);
    }
    
    {
        return daoFactory.getAlumnoDAO().listarAlumnos(nombre);
    }
    
    public static int insertarProfesor(Profesor profesor){
        return daoFactory.getProfesorDAO().insertarProfesor(profesor);
    }
    
    public static int actualizarProfesor(Profesor profesor){
        return daoFactory.getProfesorDAO().actualizarProfesor(profesor);
    }
    
    public static int eliminarProfesor(String idProfesor){
        return daoFactory.getProfesorDAO().eliminarProfesor(idProfesor);
    }
    
    public static int insertarEspecialidad(Especialidad especialidad){
        return daoFactory.getEspecialidadDAO().insertarEspecialidad(especialidad);
    }
    
    public static int actualizarEspecialidad(Especialidad especialidad){
        return daoFactory.getEspecialidadDAO().actualizarEspecialidad(especialidad);
    }
    
    public static int eliminarEspecialidad(int idEspecialidad){
        return daoFactory.getEspecialidadDAO().eliminarEspecialidad(idEspecialidad);
    }
   
    public static void insertarIdioma(Idioma idioma){
        daoFactory.getIdiomaDAO().insertarIdioma(idioma);
    }
    
    public static void actualizarPassword(String codigo, String password){
        daoFactory.getPersonaDAO().actualizarPasswordAlumno(codigo, password);
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
    
    public static void insertarTemaxClassroom(Tema_x_Classroom tema){
        daoFactory.getTemaxClassroomDAO().insertarTemaxClassroom(tema);
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
    
    public static ArrayList<SolicitudClassroom> listarSolicitudesClassroom(int estadoSolicitud){
        return daoFactory.getSolicitudClassroomDAO().listarSolicitudesClassroom(estadoSolicitud);
    }
    
    public static ArrayList<Tema> listarTemas(){
        return daoFactory.getTemaDAO().listarTemas();
    }
    
    public static ArrayList<Tema_x_Classroom> listarTemaxClassroom(String id){
        return daoFactory.getTemaxClassroomDAO().listarTemaxClassroom(id);
    }
    
    public static void insertarEvaluacion(Evaluacion evaluacion,String codClass,int codTema){
        daoFactory.getEvaluacionDAO().insertarEvaluacion(evaluacion,codClass,codTema);
    }
    
    public static ArrayList<Especialidad> listarEspecialidades(String nombre)
    {
        return daoFactory.getEspecialidadDAO().listarEspecialidades(nombre);
    }
}
