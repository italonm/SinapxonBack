/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    public void insertarTema(Tema tema) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_TEMA(?,?,?,?,?)}");
            cs.setString("_NOMBRE", tema.getNombre());
            cs.setString("_DESCRIPCION",tema.getDescripcion());
            cs.setString("_LINK", tema.getLink());
            cs.setString("_COD_CLASSROOM", tema.getClassroom().getCodigo());
            cs.registerOutParameter("_ID_TEMA",java.sql.Types.INTEGER);
            cs.executeUpdate();
            tema.setId_tema(cs.getInt("_ID_TEMA"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }
    
}
