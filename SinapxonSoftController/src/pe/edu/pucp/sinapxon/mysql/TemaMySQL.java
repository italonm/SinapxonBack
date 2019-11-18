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
import pe.edu.pucp.sinapxon.dao.TemaDAO;
import pe.edu.pucp.sinapxon.model.Tema;

/**
 *
 * @author Italo
 */
public class TemaMySQL implements TemaDAO{

    Connection con;
    CallableStatement cs;
    
    @Override
    public ArrayList<Tema> listarTemas() {
        ArrayList<Tema> temas = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_TEMAS(?)}");
            cs.setString("_NOMBRE_TEMA", "");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Tema tema = new Tema();
                tema.setId_tema(rs.getInt("ID_TEMA"));
                tema.setNombre(rs.getString("NOMBRE"));
                tema.setDescripcion(rs.getString("DESCRIPCION"));
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
