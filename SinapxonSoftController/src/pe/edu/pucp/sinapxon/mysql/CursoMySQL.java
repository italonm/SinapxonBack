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
    CallableStatement cs1;
    CallableStatement cs2;
    
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
            for(Curso cur : cursos){
                cs1 = con.prepareCall("{call LISTAR_REQUISITOS(?)}");
                cs1.setString("_CODIGO_CURSO", cur.getCodigo());
                rs = cs1.executeQuery();
                while(rs.next()){
                    Curso creq = new Curso();
                    creq.setCodigo(rs.getString("FID_REQUISITO"));
                    cs2 = con.prepareCall("{call DATOS_REQUISITOS(?,?,?,?,?,?)}");
                    cs2.setString("_FID_REQUISITO",creq.getCodigo());
                    cs2.executeQuery();
                    creq.setNombre(rs.getString("_NOMBRE"));
                    creq.setDescripcion(rs.getString("_DESCRIPCION"));
                    creq.getAdministrador().setCodigo(rs.getString("_FID_ADMINISTRADOR"));
                    creq.getEspecialidad().setId_especialidad(rs.getInt("_FID_ESPECIALIDAD"));
                    creq.setEstado(rs.getInt("_ESTADO"));
                    cur.getCursos().add(creq);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return cursos;
    }

    @Override
    public int insertarCurso(Curso curso) {
        int resultado =0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            con.setAutoCommit(false);
            cs = con.prepareCall("{call INSERTAR_CURSO(?,?,?,?,?)}");
            cs.setInt("_FID_ESPECIALIDAD", curso.getEspecialidad().getId_especialidad());
            cs.setString("_FID_ADMINISTRADOR", curso.getAdministrador().getCodigo());
            cs.setString("_ID_CURSO", curso.getCodigo());
            cs.setString("_NOMBRE",curso.getNombre());
            cs.setString("_DESCRIPCION",curso.getDescripcion());
            cs.executeUpdate();
            for(Curso cur : curso.getCursos()){
                cs = con.prepareCall("{call INSERTAR_REQUISITO(?,?)}");
                cs.setString("_FID_CURSO", curso.getCodigo());
                cs.setString("_FID_REQUISITO", cur.getCodigo());
                cs.executeUpdate();
            }
            con.commit();
            resultado=1;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
    @Override
    public int actualizarCurso(Curso curso) {
        int resultado=0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ACTUALIZAR_CURSO(?,?,?,?,?,?)}");
            cs.setInt("_FID_ESPECIALIDAD", curso.getEspecialidad().getId_especialidad());
            cs.setString("_FID_ADMINISTRADOR", curso.getAdministrador().getCodigo());
            cs.setString("_ID_CURSO", curso.getCodigo());
            cs.setString("_NOMBRE",curso.getNombre());
            cs.setString("_DESCRIPCION",curso.getDescripcion());
            cs.setString("_ESTADO",curso.getDescripcion());
            cs.executeUpdate();
            for(Curso cur : curso.getCursos()){
                cs = con.prepareCall("{call INSERTAR_REQUISITO(?,?)}");
                cs.setString("_FID_CURSO", curso.getCodigo());
                cs.setString("_FID_REQUISITO", cur.getCodigo());
                cs.executeUpdate();
            }
            con.commit();
            resultado=1;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
    @Override
    public int eliminarCurso(String idCurso) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_CURSO(?)}");
            cs.setString("_ID_CURSO", idCurso);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
