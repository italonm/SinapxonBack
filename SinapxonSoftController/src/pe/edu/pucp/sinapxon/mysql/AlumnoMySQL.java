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
import pe.edu.pucp.sinapxon.dao.AlumnoDAO;
import pe.edu.pucp.sinapxon.model.Alumno;

/**
 *
 * @author Italo
 */
public class AlumnoMySQL implements AlumnoDAO{

    Connection con;
    Statement st = null;
    CallableStatement cs;
    
    @Override
    public void insertarAlumno(Alumno alumno) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_ALUMNO(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("_ID_ALUMNO", alumno.getCodigo());
            cs.setInt("_FID_PAIS", alumno.getPais().getId_pais());
            cs.setString("_NICKNAME", alumno.getNickname());
            cs.setString("_PASSWORD",alumno.getPassword());
            cs.setString("_NOMBRE", alumno.getNombre());
            cs.setString("_AP_PATERNO",alumno.getApellidoPaterno());
            cs.setString("_AP_MATERNO", alumno.getApellidoMaterno());
            cs.setDate("_FECHA_NACIMIENTO", new java.sql.Date(alumno.getFecha().getTime()));
            cs.setString("_DNI", alumno.getDni());
            cs.setString("_CORREO", alumno.getCorreo());
            cs.setString("_TELEFONO", alumno.getTelefono());
            cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }
    
    
}
