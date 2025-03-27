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
    private String id, nombre, raza;
    private int edad;
    private PersonaDTO dto;

    public MascotaDTO(String id, String nombre, String raza, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }
    
    

    
    
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

    @Override
    public String toString() {
        return getId() + " - " + getNombre();
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
}
