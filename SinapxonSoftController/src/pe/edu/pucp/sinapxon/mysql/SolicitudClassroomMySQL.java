/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.SolicitudClassroomDAO;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.Profesor;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;

/**
 *
 * @author Rick
 */
public class SolicitudClassroomMySQL implements SolicitudClassroomDAO{

    Connection con;
    CallableStatement cs;
    
    @Override
    public void insertarSolicitudClassroom(SolicitudClassroom solicitudclassroom) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call SOLICITAR_CREACION_CLASSROOM(?,?,?,?,?,?,?)}");
            cs.setString("_FID_PROFESOR", solicitudclassroom.getProfesor().getCodigo());
            cs.setString("_FID_ADMINISTRADOR", solicitudclassroom.getAdministrador().getCodigo());
            cs.setString("_FID_CURSO", solicitudclassroom.getCurso().getCodigo());
            cs.setInt("_FID_PERIODO", solicitudclassroom.getPeriodo().getId_periodo());
            cs.setString("_DESCRIPCION", solicitudclassroom.getDescripcion());
            cs.setInt("_FID_IDIOMA", solicitudclassroom.getIdioma().getId_idioma());
            cs.registerOutParameter("_ID_SOLICITUD", java.sql.Types.INTEGER);
            cs.executeUpdate();
            solicitudclassroom.setId_solicitud(cs.getInt("_ID_SOLICITUD"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public ArrayList<SolicitudClassroom> listarSolicitudesClassroom(int estadoSolicitud) {
        ArrayList<SolicitudClassroom> solicitudes = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_SOLICITUDES_CLASSROOM(?)}");
            cs.setInt("_TIPO", estadoSolicitud);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                SolicitudClassroom sc = new SolicitudClassroom();                
                Profesor prof = new Profesor();
                Periodo per = new Periodo();
                Idioma idioma = new Idioma();
                Curso curso = new Curso();
                
                sc.setId_solicitud(rs.getInt("ID_SOLICITUD"));
                sc.setDescripcion(rs.getString("DESCRIPCION"));
                sc.setFecha(rs.getDate("FECHA_SOLICITUD"));
                curso.setCodigo(rs.getString("CODIGO_CURSO"));
                curso.setNombre(rs.getString("NOMBRE_CURSO"));
                sc.setCurso(curso);
                prof.setCodigo(rs.getString("CODIGO_PROFESOR"));
                prof.setNombre(rs.getString("NOMBRE_PROFESOR"));
                prof.setAreaInteres(rs.getString("AREA_INTERES"));
                prof.setGradoInstruccion(rs.getString("GRADO_INSTRUCCION"));
                sc.setProfesor(prof);
                per.setNombre(rs.getString("PERIODO"));
                sc.setPeriodo(per);
                idioma.setNombre(rs.getString("IDIOMA"));
                sc.setIdioma(idioma);
                
                solicitudes.add(sc);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return solicitudes;
    }

    @Override
    public void aceptarRechazarSolicitudClassroom(int idSolicitud, int estadoSolicitud) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ACEPTAR_RECHAZAR_SOLICITUD_CLASSROOM(?,?)}");
            cs.setInt("_ID_SOLICITUD", idSolicitud);
            cs.setInt("_ESTADO", estadoSolicitud);
            cs.executeUpdate();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public ArrayList<SolicitudClassroom> listarSolicitudesClassroomxProfesor(String codigoProfesor) {
        ArrayList<SolicitudClassroom> solicitudes = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_SOLICITUDES_CLASSROOM_PROFESOR(?)}");
            cs.setString("_CODIGO", codigoProfesor);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                SolicitudClassroom sc = new SolicitudClassroom();                
                Profesor prof = new Profesor();
                Periodo per = new Periodo();
                Idioma idioma = new Idioma();
                Curso curso = new Curso();
                
                sc.setId_solicitud(rs.getInt("ID_SOLICITUD"));
                sc.setDescripcion(rs.getString("DESCRIPCION"));
                sc.setFecha(rs.getDate("FECHA_SOLICITUD"));
                curso.setCodigo(rs.getString("CODIGO_CURSO"));
                curso.setNombre(rs.getString("NOMBRE_CURSO"));
                sc.setCurso(curso);
                prof.setCodigo(rs.getString("CODIGO_PROFESOR"));
                prof.setNombre(rs.getString("NOMBRE_PROFESOR"));
                prof.setAreaInteres(rs.getString("AREA_INTERES"));
                prof.setGradoInstruccion(rs.getString("GRADO_INSTRUCCION"));
                sc.setProfesor(prof);
                per.setNombre(rs.getString("PERIODO"));
                sc.setPeriodo(per);
                idioma.setNombre(rs.getString("IDIOMA"));
                sc.setIdioma(idioma);
                
                solicitudes.add(sc);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return solicitudes;
    }
}
