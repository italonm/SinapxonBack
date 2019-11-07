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
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;
import pe.edu.pucp.sinapxon.model.Tema;

/**
 *
 * @author Italo
 */
@WebService(serviceName = "ProfesorServices")
public class ProfesorServices {

    @WebMethod(operationName = "listarClassroomxProfesor")
    public ArrayList<Classroom> listarClassroomxProfesor(@WebParam(name="codigo")String codigo) {
        ArrayList<Classroom> clas =  DBController.listarClassroomxProfesor(codigo);
        return clas;
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
    @WebMethod(operationName = "insertarTema")
    public void insertarTema(@WebParam(name="tema")Tema tema){
        DBController.insertarTema(tema);
    }
}
