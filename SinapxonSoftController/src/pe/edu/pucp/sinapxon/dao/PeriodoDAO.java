/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.sinapxon.model.Periodo;

/**
 *
 * @author ld_ra
 */
public interface PeriodoDAO {
    public void insertarPeriodo(Periodo periodo);
    public ArrayList<Periodo> listarPeriodo();
    public ArrayList<Periodo> listarPeriodosDisponibles();
    public ArrayList<Periodo> listarRangoPeriodos(Date fechaIni, Date fechaFin);
    public Periodo obtenerPeriodo_X_Codigo(int codigo);
}
