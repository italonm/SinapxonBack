/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Evaluacion;

/**
 *
 * @author Rick
 */
public interface EvaluacionDAO {
    public void insertarEvaluacion(Evaluacion evaluacion,String cod,int codTema);
    public ArrayList<Evaluacion> listarEvaluacionesXClassroom(String codigoClassroom);
    public void eliminarEvaluacionxClassroom(int codigo);
}
