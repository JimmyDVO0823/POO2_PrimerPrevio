/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package p2.guarderia.modelo;

import java.util.ArrayList;

/**
 *
 * @author borisperezg
 */
public interface IDAO {
    public void agregar(IObjetoDTO dto) throws Exception;
    public void eliminar(String id);
    public void actiualizar(String id, IObjetoDTO dto);
    public IObjetoDTO buscar(String id) throws Exception;
    public ArrayList<IObjetoDTO> listar();
    
}
