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
import pe.edu.pucp.sinapxon.dao.Archivo_x_EntregableDAO;
import pe.edu.pucp.sinapxon.model.Archivo_x_Entregable;

/**
 *
 * @author ld_ra
 */
public class Archivo_x_EntregableMySQL implements Archivo_x_EntregableDAO{

    Connection con = null;
    CallableStatement cs;
    
    @Override
    public int insertarArchivo_x_Entregable(Archivo_x_Entregable archivo) {
        int resultado = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_ARCHIVO_X_ENTREGABLE(?)}");
            cs.setString("_NOMBRE", archivo.getNombre());
            cs.registerOutParameter("_ID_ARCHIVO_X_ENTREGABLE", java.sql.Types.INTEGER);
            cs.executeUpdate();
            resultado = cs.getInt("_ID_ARCHIVO_X_ENTREGABLE");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            try{con.rollback();}catch(SQLException exe){System.out.println(exe.getMessage());}
        }finally{
            try{con.setAutoCommit(true);cs.close();con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
}
