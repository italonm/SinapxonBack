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
import pe.edu.pucp.sinapxon.dao.IdiomaDAO;
import pe.edu.pucp.sinapxon.model.Idioma;

/**
 *
 * @author Italo
 */
public class IdiomaMySQL implements IdiomaDAO{

    Connection con;
    CallableStatement cs;
    
    @Override
    public ArrayList<Idioma> listarIdiomas() {
        ArrayList<Idioma> idiomas = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_IDIOMAS()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Idioma idioma = new Idioma();
                idioma.setNombre(rs.getString("NOMBRE"));
                idioma.setId_idioma(rs.getInt("ID_IDIOMA"));
                idiomas.add(idioma);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return idiomas;
    }
    
    @Override
    public void insertarIdioma(Idioma idioma) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_IDIOMA(?,?)}");
            cs.setString("_NOMBRE", idioma.getNombre());
            cs.registerOutParameter("_ID_IDIOMA", java.sql.Types.INTEGER);
            cs.executeUpdate();
            idioma.setId_idioma(cs.getInt("_ID_IDIOMA"));
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex){System.out.println();}
        }
    }
}
