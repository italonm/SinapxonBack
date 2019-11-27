package pe.edu.pucp.sinapxon.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.sinapxon.config.DBManager;
import pe.edu.pucp.sinapxon.dao.Archivo_x_EntregableDAO;
import pe.edu.pucp.sinapxon.model.Archivo_x_Entregable;
import pe.edu.pucp.sinapxon.model.Entregable;

/* @author Rick Fuyo */
public class Archivo_x_EntregableMySQL implements Archivo_x_EntregableDAO {

    Connection con = null;
    CallableStatement cs;
    
    @Override
    public ArrayList<Archivo_x_Entregable> listarArchivosXEntregable(Entregable entregable) {
        ArrayList<Archivo_x_Entregable> archs = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.user, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_ARCHIVOS_X_ENTREGABLE(?,?,?)}");
            cs.setInt("_FID_EVALUACION", entregable.getEvaluacion().getId_evaluacion());
            cs.setString("_FID_ALUMNO", entregable.getAlumno().getAlumno().getCodigo());
            cs.setString("_FID_CLASSROOM", entregable.getAlumno().getClassroom().getCodigo());
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Archivo_x_Entregable axe = new Archivo_x_Entregable();
                axe.setId_archivo_x_entregable(rs.getInt("ID_ARCHIVO_X_ENTREGABLE"));
                axe.setNombre(rs.getString("NOMBRE"));
                archs.add(axe);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return archs;
    }

}
