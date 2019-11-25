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
import pe.edu.pucp.sinapxon.dao.TemaxClassroomDAO;
import pe.edu.pucp.sinapxon.model.Tema_x_Classroom;

/**
 *
 * @author Italo
 */
public class TemaxClassroomMySQL implements TemaxClassroomDAO{
    
    Connection con;
    CallableStatement cs;
    @Override
    public void insertarTemaxClassroom(Tema_x_Classroom tema) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_TEMA(?,?,?,?)}");
            cs.setInt("_ID_TEMA", tema.getTema().getId_tema());
            cs.setString("_COD_CLASSROOM",tema.getClassroom().getCodigo());
            cs.setString("_DESCRIPCION", tema.getDescripcion());
            cs.setString("_LINK", tema.getLink());
            cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
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
    
}
