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
import pe.edu.pucp.sinapxon.dao.CursoDAO;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Curso;

/**
 *
 * @author Italo
 */
public class CursoMySQL implements CursoDAO{

    Connection con;
    Statement st = null;
    CallableStatement cs;
    
    @Override
    public ArrayList<Curso> listarCurso(String nombre) {
        ArrayList<Curso> cursos = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_CURSOS(?)}");
            cs.setString("_NOMBRE_CURSO",nombre);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Curso curso = new Curso();
                curso.setNombre(rs.getString("NOMBRE"));
                curso.setCodigo(rs.getString("CODIGO"));
                curso.setDescripcion(rs.getString("DESCRIPCION"));
                cursos.add(curso);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return cursos;
    }

    @Override
    public void insertarCurso(Curso curso) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_CURSO(?,?,?,?,?)}");
            cs.setInt("_FID_ESPECIALIDAD", curso.getEspecialidad().getId_especialidad());
            cs.setString("_FID_ADMINISTRADOR", curso.getAdministrador().getCodigo());
            cs.setString("_ID_CURSO", curso.getCodigo());
            cs.setString("_NOMBRE",curso.getNombre());
            cs.setString("_DESCRIPCION",curso.getDescripcion());
            cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }
    
}
