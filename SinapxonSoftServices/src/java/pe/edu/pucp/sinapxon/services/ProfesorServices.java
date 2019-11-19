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
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Evaluacion;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;
import pe.edu.pucp.sinapxon.model.Tema;
import pe.edu.pucp.sinapxon.model.Tema_x_Classroom;

/**
 *
 * @author Italo
 */
@WebService(serviceName = "ProfesorServices")
public class ProfesorServices {

    @WebMethod(operationName = "listarClassroomxProfesor")
    public ArrayList<Classroom> listarClassroomxProfesor(@WebParam(name="codigo")String codigo, @WebParam(name="nombre")String nombre) {
        return DBController.listarClassroomxProfesor(codigo,nombre);
    }
    
    @WebMethod(operationName = "listarCursos")
    public ArrayList<Curso> listarCursos(String nombre) {
        ArrayList<Curso> cursos = DBController.listarCursos(nombre);
        return cursos;
    }
    
    @WebMethod(operationName= "listarIdiomas")
    public ArrayList<Idioma> listarIdiomas(){
        return DBController.listarIdiomas();
    }
    
    @WebMethod(operationName = "listarPeriodos")
    public ArrayList<Periodo> listarPeriodos()
    {
        ArrayList<Periodo> periodos = DBController.listarPeriodos();
        return periodos;
    }
    
    @WebMethod(operationName = "insertarSolicitudClassroom")
    public void insertarSolicitudClassroom(@WebParam(name="solicitudclassroom")SolicitudClassroom solicitudclassroom){
        DBController.insertarSolicitudClassroom(solicitudclassroom);
    }
    
    @WebMethod(operationName = "insertarTemaxClassroom")
    public void insertarTemaxClassroom(@WebParam(name="tema")Tema_x_Classroom tema){
        DBController.insertarTemaxClassroom(tema);
    }
    
    @WebMethod(operationName = "listarTemas")
    public ArrayList<Tema> listarTemas(){
        return DBController.listarTemas();
    }
    
    @WebMethod(operationName = "listarTemaxClassroom")
    public ArrayList<Tema_x_Classroom> listarTemaxClassroom(String id){
        return DBController.listarTemaxClassroom(id);
    }
    
    @WebMethod(operationName = "insertarEvaluacion")
    public void insertarEvaluacion(@WebParam(name="evaluacion")Evaluacion evaluacion,@WebParam(name="codClass")String codClass,@WebParam(name="codTema")int codTema){
        DBController.insertarEvaluacion(evaluacion, codClass,codTema);
    }
    
    @WebMethod(operationName = "listarAlumnoXClassroom")
    public ArrayList<Alumno> listarAlumnoXClassroom(@WebParam(name="codigo")String codClassroom){
        return DBController.listarAlumnoXClassroom(codClassroom);
    }
}
