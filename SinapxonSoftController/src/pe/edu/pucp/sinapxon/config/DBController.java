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
 * @author Rick
 */
public abstract class DBController {
    
    private static final DAOFactory daoFactory = DAOFactory.getDAOFactory();
    
    //=========================================================================================
    //Catálogo de métodos de acceso
    public static Persona validarLogin (String nickname,String password){
        return daoFactory.getPersonaDAO().validar(nickname, password);
    }
    
    public static Persona validarCorreo (String correo){
        return daoFactory.getPersonaDAO().validarCorreo(correo);
    }
    
    public static void actualizarPassword(String codigo, String password){
        daoFactory.getPersonaDAO().actualizarPasswordAlumno(codigo, password);
    }
    
    public static Alumno validarNickname(String nickname){
        return daoFactory.getAlumnoDAO().validarNickname(nickname);
    }
    
    //=========================================================================================
    //Classroom
    public static void insertarClassroom(Classroom classroom){
        daoFactory.getClassroomDAO().insertarClassroom(classroom);
    }
    
    public static ArrayList<Classroom> listarClassroomxProfesor(String codigo,String nombre){
        return daoFactory.getClassroomDAO().listarClassroomxProfesor(codigo,nombre);
    }
    
    public static ArrayList<Classroom> listarClassroomxAlumno(String codigo){
        return daoFactory.getClassroomDAO().listarClassroomxAlumno(codigo);
    }
    
    public static ArrayList<Classroom> listarClassroomxCurso(Curso cursoIn){
        return daoFactory.getClassroomDAO().listarClassroomxCurso(cursoIn);
    }
    
    //=========================================================================================
    //Solicitud Classroom
    public static void insertarSolicitudClassroom(SolicitudClassroom solicitudclassroom){
        daoFactory.getSolicitudClassroomDAO().insertarSolicitudClassroom(solicitudclassroom);
    }
    
    public static void aceptarRechazarSolicitudClassroom(int idClassroom, int estadoSolicitud){
        daoFactory.getSolicitudClassroomDAO().aceptarRechazarSolicitudClassroom(idClassroom, estadoSolicitud);
    }
    
    public static ArrayList<SolicitudClassroom> listarSolicitudesClassroom(int estadoSolicitud){
        return daoFactory.getSolicitudClassroomDAO().listarSolicitudesClassroom(estadoSolicitud);
    }
    
    public static ArrayList<SolicitudClassroom> listarSolicitudesClassroomxProfesor(String codigo){
        return daoFactory.getSolicitudClassroomDAO().listarSolicitudesClassroomxProfesor(codigo);
    }
    public static void crearClassroomYasignarProfesor(SolicitudClassroom solicitudClassroom){
        daoFactory.getSolicitudClassroomDAO().crearClassroom_y_asignarProfesor(solicitudClassroom);
    }
    //=========================================================================================
    //Tema
    public static ArrayList<Tema> listarTemas(){
        return daoFactory.getTemaDAO().listarTemas();
    }
    
    public static ArrayList<Tema_x_Classroom> listarTemaxClassroom(String id){
        return daoFactory.getTemaxClassroomDAO().listarTemaxClassroom(id);
    }
    
    public static void insertarTemaxClassroom(Tema_x_Classroom tema){
        daoFactory.getTemaxClassroomDAO().insertarTemaxClassroom(tema);
    }
    
    //=========================================================================================
    //Evaluacion
    public static void insertarEvaluacion(Evaluacion evaluacion,String codClass,int codTema){
        daoFactory.getEvaluacionDAO().insertarEvaluacion(evaluacion,codClass,codTema);
    }
    
    public static ArrayList<Evaluacion> listarEvaluacionesXClassroom(String codigoClassroom){
        return daoFactory.getEvaluacionDAO().listarEvaluacionesXClassroom(codigoClassroom);
    }
    
    //=========================================================================================
    //Curso
    public static void insertarCurso(Curso curso){
        daoFactory.getCursoDAO().insertarCurso(curso);
    }
    
    public static int actualizarCurso(Curso curso){
        return daoFactory.getCursoDAO().actualizarCurso(curso);
    }
    
    public static int eliminarCurso(String idCurso){
        return daoFactory.getCursoDAO().eliminarCurso(idCurso);
    }
    
    public static ArrayList<Curso> listarCursos(String nombre)
    {
        return daoFactory.getCursoDAO().listarCurso(nombre);
    }
    
    public static ArrayList<Curso> listarRequisitos(String codCur)
    {
        return daoFactory.getCursoDAO().listarRequisitos(codCur);
    }
    
    public static ArrayList<Curso> listarCursosSin(String nombre)
    {
        return daoFactory.getCursoDAO().listarCursoSin(nombre);
    }
    
    //=========================================================================================
    //Periodos
    public static void insertarPeriodo(Periodo periodo){
        daoFactory.getPeriodoDAO().insertarPeriodo(periodo);
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
    
    public static Periodo obtenrPeriodo_X_codigo(int codigo){
        return daoFactory.getPeriodoDAO().obtenerPeriodo_X_Codigo(codigo);
    }
    //=========================================================================================
    //Alumno
    public static int insertarAlumno(Alumno alumno){
        return daoFactory.getAlumnoDAO().insertarAlumno(alumno);
    }
    
    public static int actualizarAlumno(Alumno alumno){
        return daoFactory.getAlumnoDAO().actualizarAlumno(alumno);
    }
    
    public static int eliminarAlumno(String idAlumno){
        return daoFactory.getAlumnoDAO().eliminarAlumno(idAlumno);
    }
    
    public static ArrayList<Alumno> listarAlumnos(String nombre){
        return daoFactory.getAlumnoDAO().listarAlumnos(nombre);
    }
    
    public static ArrayList<Alumno> listarAlumnoXClassroom(String codigoClassrom){
        return daoFactory.getAlumnoDAO().listarAlumnosXClassroom(codigoClassrom);
    }
    
    public static int insertarAlumno_classroom(String codAlumno, String codClassroom)
    {
        return daoFactory.getAlumnoDAO().insertarAlumno_a_un_classroom(codAlumno, codClassroom);
    }
    //=========================================================================================
    //Profesor
    public static int insertarProfesor(Profesor profesor){
        return daoFactory.getProfesorDAO().insertarProfesor(profesor);
    }
    
    public static int actualizarProfesor(Profesor profesor){
        return daoFactory.getProfesorDAO().actualizarProfesor(profesor);
    }
    
    public static int eliminarProfesor(String idProfesor){
        return daoFactory.getProfesorDAO().eliminarProfesor(idProfesor);
    }
    
    public static ArrayList<Profesor> listarProfesores(String nombre){
        return daoFactory.getProfesorDAO().listarProfesores(nombre);
    }
    
    public static ArrayList<Profesor> listarProfesoresXCurso(String codigoCurso){
        return daoFactory.getProfesorDAO().listarProfesoresXCurso(codigoCurso);
    }
    
    //=========================================================================================
    //Especialidad
    public static int insertarEspecialidad(Especialidad especialidad){
        return daoFactory.getEspecialidadDAO().insertarEspecialidad(especialidad);
    }
    
    public static int actualizarEspecialidad(Especialidad especialidad){
        return daoFactory.getEspecialidadDAO().actualizarEspecialidad(especialidad);
    }
    
    public static int eliminarEspecialidad(int idEspecialidad){
        return daoFactory.getEspecialidadDAO().eliminarEspecialidad(idEspecialidad);
    }
    
    public static ArrayList<Especialidad> listarEspecialidades(){
        return daoFactory.getEspecialidadDAO().listarEspecialidades();
    }
    
    public static ArrayList<Especialidad> listarEspecialidades(String nombre){
        return daoFactory.getEspecialidadDAO().listarEspecialidades(nombre);
    }
    
    //=========================================================================================
    //Idioma
    public static void insertarIdioma(Idioma idioma){
        daoFactory.getIdiomaDAO().insertarIdioma(idioma);
    }
    
    public static ArrayList<Idioma> listarIdiomas(){
        return daoFactory.getIdiomaDAO().listarIdiomas();
    }
    
    public static ArrayList<Idioma> listarIdiomasXNombre_codigo(String nombreCod){
        return daoFactory.getIdiomaDAO().listarIdiomasXNombre_codigo(nombreCod);
    }
    //=========================================================================================
    //Pais
    public static void insertarPais(Pais pais){
        daoFactory.getPaisDAO().insertarPais(pais);
    }
    
    public static ArrayList<Pais> listarPaises(){
        return daoFactory.getPaisDAO().listarPaises();
    }
}