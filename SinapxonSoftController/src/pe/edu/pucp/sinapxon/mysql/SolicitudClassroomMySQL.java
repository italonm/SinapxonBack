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
import java.util.Random;
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
    Connection con2;
    Connection con3;
    Connection con4;
    CallableStatement cs;
    CallableStatement cs2;
    CallableStatement cs3;
    CallableStatement cs4;
    
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
                sc.setEstado(rs.getInt("ESTADO"));
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
    public int crearClassroom_y_asignarProfesor(SolicitudClassroom solicitudClassroom) {
        int salida = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Random randomGen = new Random();
            String codigoClassroom = "H-";
            for(int i=0; i<4; i++)
            {
                codigoClassroom = codigoClassroom+String.valueOf(randomGen.nextInt(10));
            }
            
            //Obtener el codigo del periodo
            con2 = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs2 = con2.prepareCall("{call LISTAR_PERIODOS_x_NOMBRE(?)}");
            cs2.setString("_NOMBRE_CODIGO", solicitudClassroom.getPeriodo().getNombre());
            ResultSet rs2 = cs2.executeQuery();
            rs2.next();
            int codigoPeriodo = rs2.getInt("ID_PERIODO");
            
            //Obtener el id del idioma
            con3 = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs3 = con3.prepareCall("{call ListarIdiomaXNombre_Codigo(?)}");
            cs3.setString("_NOMBRE_CODIGO", solicitudClassroom.getIdioma().getNombre());
            ResultSet rs3 = cs3.executeQuery();
            rs3.next();
            int idIdioma = rs3.getInt("ID_IDIOMA");
            
            //Insertamos el nuevo classroom
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_CLASSROOM(?,?,?,?)}");
            cs.setString("_CODIGO", codigoClassroom);
            cs.setString("_FID_CURSO", solicitudClassroom.getCurso().getCodigo());
            cs.setInt("_FID_PERIODO", codigoPeriodo);
            cs.setInt("_FID_IDIOMA", idIdioma);
            cs.executeQuery();
            
            //Asignamos el profesor al nuevo classroom
            con4 = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs4 = con4.prepareCall("{call REGISTRAR_PROFESOR_EN_CLASSROOM(?,?)}");
            cs4.setString("_FID_CLASSROOM", codigoClassroom);
            cs4.setString("_FID_PROFESOR", solicitudClassroom.getProfesor().getCodigo());
            cs4.executeQuery();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return salida;
    }
}
