/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.services;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.sinapxon.config.DBController;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Archivo_x_Tema;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Evaluacion;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;
import pe.edu.pucp.sinapxon.model.Tema;
import pe.edu.pucp.sinapxon.model.Tema_x_Classroom;
import pe.edu.pucp.sinapxon.servlet.ServletReport;

/**
 *
 * @author Rick
 */
@WebService(serviceName = "ProfesorServices")
public class ProfesorServices {

    public ProfesorServices(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    
    @WebMethod(operationName = "listarClassroomxProfesor")
    public ArrayList<Classroom> listarClassroomxProfesor(@WebParam(name="codigo")String codigo, @WebParam(name="nombre")String nombre) {
        return DBController.listarClassroomxProfesor(codigo,nombre);
    }
    
    @WebMethod(operationName = "listarCursos")
    public ArrayList<Curso> listarCursos(String nombre) {
        return DBController.listarCursos(nombre);
    }
    
    @WebMethod(operationName= "listarIdiomas")
    public ArrayList<Idioma> listarIdiomas(){
        return DBController.listarIdiomas();
    }
    
    @WebMethod(operationName = "listarPeriodos")
    public ArrayList<Periodo> listarPeriodos(){
        return DBController.listarPeriodos();
    }
    
    @WebMethod(operationName = "insertarSolicitudClassroom")
    public void insertarSolicitudClassroom(@WebParam(name="solicitudclassroom")SolicitudClassroom solicitudclassroom){
        DBController.insertarSolicitudClassroom(solicitudclassroom);
    }
    
    @WebMethod(operationName = "listarSolicitudesClassroomxProfesor")
    public ArrayList<SolicitudClassroom>  listarSolicitudesClassroomxProfesor(@WebParam(name="solicitudclassroom")String codigo){
        return DBController.listarSolicitudesClassroomxProfesor(codigo);
    }
    
    @WebMethod(operationName = "insertarTemaxClassroom")
    public void insertarTemaxClassroom(@WebParam(name="tema")Tema_x_Classroom tema){
        DBController.insertarTemaxClassroom(tema);
    }
    
    @WebMethod(operationName = "insertarArchivoXTema")
    public int insertarArchivo(Archivo_x_Tema archivo, int idTema, String idClassroom){
        return DBController.insertarArchivos(archivo,idTema,idClassroom);
    }
    
    @WebMethod(operationName = "guardarArchivoxTema")
    public void guardarArchivoxTema(byte[] archivo,int idArchivo){
        DBController.guardarArchivoxTema(archivo,idArchivo);
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
    
    @WebMethod(operationName = "listarEvaluacionesXClassroom")
    public ArrayList<Evaluacion> listarEvaluacionesXClassroom(@WebParam(name="codigo")String codClassroom){
        return DBController.listarEvaluacionesXClassroom(codClassroom);
    }
    
    
    @WebMethod(operationName = "eliminarTemaxClassroom")
    public void eliminarTemaxClassroom(@WebParam(name="codTema")int codTema,@WebParam(name="codClassroom")String codClassroom){
        DBController.eliminarTemaxClassroom(codTema,codClassroom);
    }
    
    @WebMethod(operationName = "eliminarEvaluacionxClassroom")
    public void eliminarEvaluacionxClassroom(@WebParam(name="codigo")int codigo){
        DBController.eliminarEvaluacionxClassroom(codigo);
    }
    
    @WebMethod(operationName = "generarReportePDF")
    public byte[] generarReportePDF(@WebParam (name = "codClassroom") String codClassroom){
        byte[] arreglo = null;
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(ServletReport.class.getResource("/pe/edu/pucp/sinapxon/reports/ReporteAlumnosConNotasXClassroom.jasper").getFile());
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            HashMap hm = new HashMap();
            hm.put("FID_CLASSROOM", codClassroom);
            JasperPrint jp = 
                    JasperFillManager.fillReport(reporte,hm,con);
            arreglo = JasperExportManager.exportReportToPdf(jp);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return arreglo;
    }
    
}
