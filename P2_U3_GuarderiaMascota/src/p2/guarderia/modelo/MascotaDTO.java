/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.guarderia.modelo;

/**
 *
 * @author borisperezg
 */
public class MascotaDTO implements IObjetoDTO {
    private String id, nombre;
    private PersonaDTO dto;

    public PersonaDTO getDto() {
        return dto;
    }

    public void setDto(PersonaDTO dto) {
        this.dto = dto;
    }

    public MascotaDTO(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public MascotaDTO() {
    }
    
    

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
