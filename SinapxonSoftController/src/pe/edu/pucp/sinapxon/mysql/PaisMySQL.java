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
import java.util.ArrayList;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.PaisDAO;
import pe.edu.pucp.sinapxon.model.Pais;

/**
 *
 * @author alulab14
 */
public class PaisMySQL implements PaisDAO{

    Connection con;
    CallableStatement cs;

    @Override
    public ArrayList<Pais> listarPais() {
        ArrayList<Pais> paises = new ArrayList<>();
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PAISES()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Pais pais = new Pais();
                pais.setId_pais(rs.getInt("ID_PAIS"));
                pais.setNombre(rs.getString("NOMBRE"));
                paises.add(pais);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return paises;
    }
}
