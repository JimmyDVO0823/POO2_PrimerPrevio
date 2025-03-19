/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package p2.guarderia.modelo;

/**
 *
 * @author borisperezg
 */
public interface IDAO {
    public void agregar(IObjetoDTO dto) throws Exception;
    public IObjetoDTO buscar(String id) throws Exception;
}
