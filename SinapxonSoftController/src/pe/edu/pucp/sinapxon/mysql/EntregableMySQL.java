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
import java.util.ArrayList;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.EntregableDAO;
import pe.edu.pucp.sinapxon.model.Entregable;

/**
 *
 * @author ld_ra
 */
public class EntregableMySQL implements EntregableDAO{
    Connection con = null;
    CallableStatement cs;

    @Override
    public void insertarEntregable(int idEvaluacion, String idAlumno, String idClassroom, String descripcion, int idArchivoXEntregable) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_ENTREGABLE(?,?,?,?,?)}");
            cs.setInt("_FID_EVALUACION", idEvaluacion);
            cs.setString("_FID_ALUMNO", idAlumno);
            cs.setString("_FID_CLASSROOM", idClassroom);
            cs.setString("_DESCRIPCION", descripcion);
            cs.setInt("_FID_ARCHIVO_X_ENTREGABLE", idArchivoXEntregable);
            cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            try{con.rollback();}catch(SQLException exe){System.out.println(exe.getMessage());}
        }finally{
            try{con.setAutoCommit(true);cs.close();con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public void eliminarEntregable(int idEvaluacion, String idAlumno, String idClassroom) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_ENTREGABLE(?,?,?,?,?)}");
            cs.setInt("_FID_EVALUACION", idEvaluacion);
            cs.setString("_FID_ALUMNO", idAlumno);
            cs.setString("_FID_CLASSROOM", idClassroom);
            cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            try{con.rollback();}catch(SQLException exe){System.out.println(exe.getMessage());}
        }finally{
            try{con.setAutoCommit(true);cs.close();con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public ArrayList<Entregable> listarEntregables(int idEvaluacion, String idAlumno, String idClassroom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
