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
import pe.edu.pucp.sinapxon.dao.EvaluacionDAO;
import pe.edu.pucp.sinapxon.model.Classroom;
import pe.edu.pucp.sinapxon.model.Evaluacion;

/**
 *
 * @author Italo
 */
public class EvaluacionMySQL implements EvaluacionDAO{

    Connection con;
    Statement st = null;
    CallableStatement cs;
    
    @Override
    public void insertarEvaluacion(Evaluacion evaluacion,String codClass,int codTema) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_EVALUACION(?,?,?,?,?)}");
            cs.setString("_NOMBRE", evaluacion.getNombre());
            cs.setString("_DESCRIPCION", evaluacion.getDescripcion());
            cs.setString("_FID_CLASSROOM",codClass );
            cs.setInt("_FID_TEMA", codTema);
            cs.setFloat("_PESO_PORCENTUAL", evaluacion.getPeso_porcentual());
            cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public ArrayList<Evaluacion> listarEvaluacionesXClassroom(String codigoClassroom) {
        ArrayList<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_EVALUACIONES_X_CLASSROOM(?)}");
            cs.setString("_CODIGO_CLASSROOM", codigoClassroom);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Evaluacion e = new Evaluacion();
                e.setId_evaluacion(rs.getInt("ID_EVALUACION"));
                e.setNombre(rs.getString("NOMBRE"));
                e.setDescripcion(rs.getString("DESCRIPCION"));
                e.setPeso_porcentual(rs.getFloat("PESO_PORCENTUAL"));
                evaluaciones.add(e);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return evaluaciones;
    }

    @Override
    public void eliminarEvaluacionxClassroom(int codigo) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_EVALUACION(?)}");
            cs.setInt("_ID_EVALUACION",codigo);
            cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }
    
}
