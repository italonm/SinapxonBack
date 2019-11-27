/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.mysql;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.TemaxClassroomDAO;
import pe.edu.pucp.sinapxon.model.Archivo_x_Tema;
import pe.edu.pucp.sinapxon.model.Tema_x_Classroom;

/**
 *
 * @author Italo
 */
public class TemaxClassroomMySQL implements TemaxClassroomDAO{
    
    Connection con;
    CallableStatement cs;
    
    @Override
    public int insertarTemaxClassroom(Tema_x_Classroom tema) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_TEMA(?,?,?,?)}");
            cs.setInt("_ID_TEMA", tema.getTema().getId_tema());
            cs.setString("_COD_CLASSROOM",tema.getClassroom().getCodigo());
            cs.setString("_DESCRIPCION", tema.getDescripcion());
            cs.setString("_LINK", tema.getLink());
            cs.registerOutParameter("_ID_EVALUACION", java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt("_ID_EVALUACION");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
            return 0;
        }
    }
    
    @Override
    public void insertarArchivos(Archivo_x_Tema archivo, int idTema, String idClassroom){
        try {
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_ARCHIVO_X_TEMA(?,?,?,?)}");
            cs.setString("_NOMBRE", archivo.getNombre());
            cs.setString("_DESCRIPCION", " ");
            cs.setInt("_FID_TEMA", idTema);
            cs.setString("_FID_CLASSROOM", idClassroom);
            cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            
    }
    @Override
    public ArrayList<Tema_x_Classroom> listarTemaxClassroom(String id) {
        ArrayList<Tema_x_Classroom> temas = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_TEMAS_X_CLASSROOM(?)}");
            cs.setString("_CODIGO_CLASSROOM", id);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Tema_x_Classroom tema = new Tema_x_Classroom();
                tema.setNombre(rs.getString("NOMBRE"));
                tema.setId_tema(rs.getInt("ID_TEMA"));
                tema.setDescripcion(rs.getString("DESCRIPCION"));
                tema.setLink(rs.getString("LINK"));
                temas.add(tema);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return temas;
    }
    
    @Override
    public void eliminarTemaxClassroom(int codTema,String codClassroom) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_TEMA(?,?)}");
            cs.setInt("_ID_TEMA",codTema);
            cs.setString("_ID_CLASSROOM",codClassroom);
            cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }
}
