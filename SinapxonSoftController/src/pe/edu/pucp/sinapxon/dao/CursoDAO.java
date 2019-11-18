/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.sinapxon.dao;

import java.util.ArrayList;
import pe.edu.pucp.sinapxon.model.Curso;

/**
 *
 * @author Italo
 */
public interface CursoDAO {
    public int insertarCurso(Curso curso);
    public int actualizarCurso(Curso curso);
    public int eliminarCurso(String idCurso);
    public ArrayList<Curso> listarCurso(String nombre);
}
