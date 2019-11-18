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
import pe.edu.pucp.sinapxon.dao.PaisDAO;
import pe.edu.pucp.sinapxon.model.Pais;

/**
 *
 * @author Emma Isabel Aragon Quenallata
 */
public class PaisMySQL implements PaisDAO {
    Connection con = null;
    CallableStatement cs;
    @Override
    public ArrayList<Pais> listarPaises() {
        ArrayList<Pais> paises = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PAISES()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Pais pais = new Pais();
                pais.setNombre(rs.getString("NOMBRE"));
                pais.setId_pais(rs.getInt("ID_PAIS"));
                paises.add(pais);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return paises;
    }
}
