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
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.ClassroomDAO;
import pe.edu.pucp.sinapxon.model.Alumno;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;
import pe.edu.pucp.sinapxon.model.Especialidad;
import pe.edu.pucp.sinapxon.model.Idioma;
import pe.edu.pucp.sinapxon.model.Periodo;
import pe.edu.pucp.sinapxon.model.Profesor;

/**
 *
 * @author Rick
 */
public class ClassroomMySQL implements ClassroomDAO{

    Connection con;
    CallableStatement cs;
    
    @Override
    public ArrayList<Classroom> listarClassroomxProfesor(String codigo,String nombre) {
        ArrayList<Classroom> classrooms = new ArrayList<Classroom>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_CLASSROOM_X_PROFESOR(?,?)}");
            cs.setString("_CODIGO", codigo);
            cs.setString("_NOMBRE", nombre);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Classroom classroom = new Classroom();
                Curso curso = new Curso();
                curso.setNombre(rs.getString("NOMBRE"));
                curso.setCodigo(rs.getString("CODCURSO"));
                curso.setDescripcion(rs.getString("DESCRIPCION"));
                classroom.setCurso(curso);
                classroom.setCodigo(rs.getString("CODCLASSROOM"));
                classroom.setProfesor(new Profesor());
                classroom.setAlumnos(new ArrayList<>());
                classroom.setTemas(new ArrayList<>());
                classroom.setPeriodo(new Periodo());
                classroom.setIdioma(new Idioma());
                classrooms.add(classroom);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return classrooms;
    }

    @Override
    public ArrayList<Classroom> listarClassroomxAlumno(String codigo) {
        ArrayList<Classroom> classrooms = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_CLASSROOM_X_ALUMNO(?)}");
            cs.setString("_CODIGO", codigo);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Classroom classroom = new Classroom();
                Curso curso = new Curso();
                Especialidad especialidad = new Especialidad();
                especialidad.setNombre(rs.getString("ESPECIALIDAD"));
                curso.setNombre(rs.getString("CURSO"));
                //curso.setCodigo(rs.getString("CODCURSO"));
                //curso.setDescripcion(rs.getString("DESCRIPCION"));
                curso.setEspecialidad(especialidad);
                classroom.setCurso(curso);
                classroom.setCodigo(rs.getString("HORARIO"));
                Profesor profesor = new Profesor();
                profesor.setNombre(rs.getString("PROFESOR"));
                classroom.setProfesor(profesor);
                classroom.setAlumnos(new ArrayList<>());
                classroom.setTemas(new ArrayList<>());
                classroom.setPeriodo(new Periodo());
                classroom.setIdioma(new Idioma());
                classrooms.add(classroom);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return classrooms;
    }

    @Override
    public void insertarClassroom(Classroom classroom) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_CLASSROOM(?,?,?,?)}");
            cs.setString("_CODIGO", classroom.getCodigo());
            cs.setString("_FID_CURSO", classroom.getCurso().getCodigo());
            cs.setInt("_FID_PERIODO", classroom.getPeriodo().getId_periodo());
            cs.setInt("_FID_IDIOMA", classroom.getIdioma().getId_idioma());
            cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
    }
}
