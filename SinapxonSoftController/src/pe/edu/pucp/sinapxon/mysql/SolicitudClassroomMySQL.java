/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.SolicitudClassroomDAO;
import pe.edu.pucp.sinapxon.model.SolicitudClassroom;

/**
 *
 * @author Italo
 */
public class SolicitudClassroomMySQL implements SolicitudClassroomDAO{

    Connection con;
    Statement st = null;
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
}
