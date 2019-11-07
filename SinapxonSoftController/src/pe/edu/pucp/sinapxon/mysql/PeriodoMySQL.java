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
import pe.edu.pucp.sinapxon.dao.PeriodoDAO;
import pe.edu.pucp.sinapxon.model.Periodo;

/**
 *
 * @author ld_ra
 */
public class PeriodoMySQL implements PeriodoDAO{
    
    Connection con;
    Statement st = null;
    CallableStatement cs;

    @Override
    public ArrayList<Periodo> listarPeriodo() {
        ArrayList<Periodo> periodos = new ArrayList<>();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PERIODOS()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
                Periodo periodo = new Periodo();
                periodo.setId_periodo(rs.getInt("ID_PERIODO"));
                periodo.setNombre(rs.getString("NOMBRE"));
                //periodo.getAdministrador().setCodigo(String.valueOf(rs.getInt("FID_ADMINISTRADOR")));
                periodo.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                periodo.setFecha_fin(rs.getDate("FECHA_FIN"));
                periodos.add(periodo);
            }
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return periodos;
    }
    
}
