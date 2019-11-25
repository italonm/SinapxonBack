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
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.ClassroomxAlumnoDAO;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Classroom_x_Alumno;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Especialidad;
import pe.edu.pucp.sinapxon.model.Profesor;

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

    @Override
    public ArrayList<Classroom> listarClassroomXAlumnoXPeriodo(String codAlumno, int id_periodo) {
        ArrayList<Classroom> classrooms = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url,DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_CLASSROOM_X_ALUMNO_X_PERIODO(?,?)}");
            cs.setString("_CODIGO",codAlumno);
            cs.setInt("_ID_PERIODO", id_periodo);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Curso curso = new Curso();
                Classroom clas = new Classroom ();
                curso.setCodigo(rs.getString("CODIGO"));
                curso.setNombre(rs.getString("CURSO"));
                Especialidad especialidad = new Especialidad();
                especialidad.setNombre(rs.getString("ESPECIALIDAD"));
                curso.setEspecialidad(especialidad);
                clas.setCurso(curso);
                clas.setCodigo(rs.getString("HORARIO"));
                Profesor profesor = new Profesor();
                profesor.setNombre(rs.getString("PROFESOR"));
                clas.setProfesor(profesor);
                classrooms.add(clas);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClassroomxAlumnoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{con.close();} catch(SQLException ex) {System.out.println(ex.getMessage());}
        }
        return classrooms;
        
    }
    
}
