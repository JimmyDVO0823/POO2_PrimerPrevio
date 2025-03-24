/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.modelo;

/**
 *
 * @author LENOVO LOQ
 */
public class PersonaDTO implements IObjetoDTO{
    private String id;
    private String nombre;

    public PersonaDTO(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public PersonaDTO() {
    }
    
    
    //GETTERS SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
