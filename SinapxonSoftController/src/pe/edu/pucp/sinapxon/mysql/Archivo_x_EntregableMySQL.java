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
import java.util.ArrayList;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.Archivo_x_EntregableDAO;
import pe.edu.pucp.sinapxon.model.Archivo_x_Entregable;
import pe.edu.pucp.sinapxon.model.Entregable;

/**
 *
 * @author ld_ra
 */
public class Archivo_x_EntregableMySQL implements Archivo_x_EntregableDAO{

    Connection con = null;
    CallableStatement cs;
    
    @Override
    public int insertarArchivo_x_Entregable(Archivo_x_Entregable archivo) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_ARCHIVO_X_ENTREGABLE(?,?)}");
            cs.setString("_NOMBRE", archivo.getNombre());
            cs.registerOutParameter("_ID_ARCHIVO_X_ENTREGABLE", java.sql.Types.INTEGER);
            cs.executeUpdate();
            resultado = cs.getInt("_ID_ARCHIVO_X_ENTREGABLE");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            try{con.rollback();}catch(SQLException exe){System.out.println(exe.getMessage());}
        }finally{
            try{con.setAutoCommit(true);cs.close();con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Archivo_x_Entregable> listarArchivosXEntregable(int idEvaluacion, String idAlumno, String idClassroom) {
        ArrayList<Archivo_x_Entregable> archs = new ArrayList<>();
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_ARCHIVOS_X_ENTREGABLE(?,?,?)}");
            cs.setInt("_FID_EVALUACION", idEvaluacion);
            cs.setString("_FID_ALUMNO", idAlumno);
            cs.setString("_FID_CLASSROOM", idClassroom);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Archivo_x_Entregable axe = new Archivo_x_Entregable();
                axe.setId_archivo_x_entregable(rs.getInt("ID_ARCHIVO_X_ENTREGABLE"));
                axe.setNombre(rs.getString("NOMBRE"));
                archs.add(axe);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return archs;
    }
    
}
