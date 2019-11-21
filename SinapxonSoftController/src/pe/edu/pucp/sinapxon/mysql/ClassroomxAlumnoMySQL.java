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
import pe.edu.pucp.sinapxon.dao.ClassroomxAlumnoDAO;
import pe.edu.pucp.sinapxon.model.Classroom_x_Alumno;

/**
 *
 * @author Rick Fuyo
 */
public class ClassroomxAlumnoMySQL implements ClassroomxAlumnoDAO{

    CallableStatement cs;
    Connection con = null;
    @Override
    public ArrayList<Classroom_x_Alumno> listarClassroomXAlumno() {
        ArrayList<Classroom_x_Alumno> classroomsXAlumno = new ArrayList<>();
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call }");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage()); }
        }
        return classroomsXAlumno;
    }
    
}
